/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.interfaces;

import java.util.ArrayList;
import java.util.List;
import pingroup.vos.Tienda;
import pingroup.vos.Usuario;


/**
 * Interfaz que declara los servicios de persistencia
 */
public interface IServicioFacebookLocal {

    /**
     * Retorna la tiendas que estan registradas en el sistema y el usuario le ha dado like
     * @param token 
     * @return Lista con las tiendas
     */
    public List<Tienda> getTiendasEnLikes(String token)throws Exception;

    /**
     * Retorna la lista de amigos de un usuario que ya estan en la aplicación
     * @param token
     */
    public List<Usuario> getAmigosQueUsanApp(String token);
    
    /**
     * Retorna un POJO Usuario con toda la informacion necesaria jalada de Facebook
     * @param token
     */
    public Usuario getUsuario(String token);
}
