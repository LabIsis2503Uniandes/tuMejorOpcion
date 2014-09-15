/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pingroup.servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import pingroup.interfaces.IServicioFacebookLocal;
import pingroup.interfaces.IServicioPersistenciaLocal;
import pingroup.vos.Cupon;
import pingroup.vos.Tienda;
import pingroup.vos.Usuario;

/**
 *
 * @author estudiante
 */
@Stateless
public class ServicioFacebook implements IServicioFacebookLocal {
    
    private IServicioPersistenciaLocal persistencia;
    
    public ServicioFacebook() {
        persistencia = new ServicioPersistenciaMock();
    }
    
    public List<Tienda> getTiendasEnLikes(String token) throws Exception{
        
        ArrayList<Tienda> tiendas = null;
        
        try {
            URL url = new URL("https://graph.facebook.com/v2.1/me?access_token="+token+"&fields=likes{link,name,category}&format=json&method=get&pretty=0&suppress_http_code=1&limit=300");
            
            HttpsURLConnection yc = (HttpsURLConnection) url.openConnection();
            
            yc.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            String json = "";
            while ((inputLine = in.readLine()) != null)
                json += inputLine;
            in.close();
            
            JSONObject resp =  (JSONObject) JSONValue.parse(json);
            
            JSONArray data = ((JSONArray)((JSONObject) (resp.get("likes"))).get("data"));
            
            tiendas = new ArrayList<Tienda>();
            
            for(Object o : data) {
                JSONObject actual = (JSONObject) o;
                
                Tienda temp = persistencia.buscarTiendaPorId(""+actual.get("id"));
                if(temp != null) {
                    tiendas.add(temp);
                }
            }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        
        return tiendas;
    }
    
    public List<Usuario> getAmigosQueUsanApp(String token) {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        try {
            URL url = new URL("https://graph.facebook.com/v2.1/me/friends?access_token="+token+"&fields=installed%2Cname&format=json&method=get&pretty=0&suppress_http_code=1");
            
            HttpsURLConnection yc = (HttpsURLConnection) url.openConnection();
            
            yc.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            String json = "";
            while ((inputLine = in.readLine()) != null)
                json += inputLine;
            in.close();
            JSONObject resp =  (JSONObject) JSONValue.parse(json);
            
            JSONArray data = (JSONArray) resp.get("data");
            
            for(Object o : data) {
                JSONObject actual = (JSONObject) o;
                
                usuarios.add(persistencia.buscarUsuarioPorIdFacebook("" + actual.get("id")));
            }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    public Usuario getUsuario(String token) {
      
        Usuario usuario = new Usuario();
        
        try {
            URL url = new URL("https://graph.facebook.com/v2.1/me?fields=email,name&access_token="+token+"&fields=installed%2Cname&format=json&method=get&pretty=0&suppress_http_code=1");
            
            HttpsURLConnection yc = (HttpsURLConnection) url.openConnection();
            
            yc.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            String json = "";
            while ((inputLine = in.readLine()) != null)
                json += inputLine;
            in.close();
            JSONObject resp =  (JSONObject) JSONValue.parse(json);
            
            usuario.setIdFacebook("" + resp.get("id"));
            usuario.setCupones(new ArrayList<Cupon>());
            usuario.setTokenFacebook(token);
            usuario.setUsername(""+resp.get("name"));
            usuario.setCorreo(""+resp.get("email"));
            usuario.setAmigos(this.getAmigosQueUsanApp(token));
            usuario.setTiendaLike(this.getTiendasEnLikes(token));
           
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return usuario;
        
    }
}
