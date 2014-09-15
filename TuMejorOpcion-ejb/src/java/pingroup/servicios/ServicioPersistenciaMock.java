/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import pingroup.interfaces.IServicioPersistenciaLocal;
import pingroup.vos.Cupon;
import pingroup.vos.Tienda;
import pingroup.vos.Usuario;

/**
 * Servicio Persistencia
 */
@Stateless
public class ServicioPersistenciaMock implements IServicioPersistenciaLocal {

    /**
     * La lista de todos los cupones creado en el sistema
     */
    private static List<Cupon> cupones;
    
    /**
     * La lista de todas las tiendas creadas en el sistema
     */
    private static List<Tienda> tiendas;
    
    /**
     * La lista de todos los usuarios creados en el sistema
     */
    private static List<Usuario> usuarios;
    
    /**
     * Usuario de prueba
     */
    private Usuario usuarioPrueba;
    
    public ServicioPersistenciaMock() {
        cupones = new  ArrayList<Cupon>();
        tiendas = new  ArrayList<Tienda>();
        usuarios = new ArrayList<Usuario>();
        
        
        //TIENDAS
        this.aniadirTienda(new Tienda("H&M", "21415640912", "https://www.facebook.com/hm", new ArrayList<Cupon>()));
        this.aniadirTienda(new Tienda("Forever 21", "295959320467678", "https://www.facebook.com/Forever21SanJuan", new ArrayList<Cupon>()));
        this.aniadirTienda(new Tienda("ARTURO CALLE", "125802010769164", "https://www.facebook.com/arturocallecolombia", new ArrayList<Cupon>()));
        this.aniadirTienda(new Tienda("ZARA", "33331950906", "https://www.facebook.com/Zara", new ArrayList<Cupon>()));

        //USUARIOS
        this.aniadirUsuario(new Usuario("lolo", "1234", "yo@yo.yo", "ñfnspiufpsfpsb", new ArrayList<Cupon>(), new ArrayList<Tienda>(), new ArrayList<Usuario>()));
        this.aniadirUsuario(new Usuario("lalo", "1235", "ya@yo.yo", "ñfnspiufasdasddaspsb", new ArrayList<Cupon>(), new ArrayList<Tienda>(), new ArrayList<Usuario>()));
        this.aniadirUsuario(new Usuario("lala", "1236", "ya@ya.yo", "ñfnspiufpereeeeeb", new ArrayList<Cupon>(), new ArrayList<Tienda>(), new ArrayList<Usuario>()));
        
        usuarioPrueba = usuarios.get(0);
        this.volverseAmigos(usuarios.get(0), usuarios.get(1));
        
        this.aniadirTiendaAUsuario(usuarios.get(2), tiendas.get(2));
        this.aniadirTiendaAUsuario(usuarios.get(0), tiendas.get(2));
        this.aniadirTiendaAUsuario(usuarios.get(1), tiendas.get(1));
        //CUPONES
        this.aniadirCupon(new Cupon(false, 7777.0, 1000.0, tiendas.get(0), this.generateIdCupon()), usuarios.get(0));
        this.aniadirCupon(new Cupon(false, 66.0, 200.0, tiendas.get(1), this.generateIdCupon()), usuarios.get(1));
        this.aniadirCupon(new Cupon(false, 0.0, 2500.0, tiendas.get(2), this.generateIdCupon()), usuarios.get(2));
    }

    @Override
    public Usuario buscarUsuarioPorToken(String token) {
        for (Usuario ac: usuarios)
            if(ac.getTokenFacebook().compareTo(token)==0)
                return ac;
        return null;
    }

    @Override
    public void aniadirUsuario(Usuario usuario) {
        if(usuario.getAmigos()==null) usuario.setAmigos(new ArrayList<Usuario> ());
        if(usuario.getCupones()==null) usuario.setCupones(new ArrayList<Cupon> ());
        if(usuario.getTiendaLike() == null) usuario.setTiendaLike(new ArrayList<Tienda> ());
        if(buscarUsuarioPorToken(usuario.getTokenFacebook())==null)
            usuarios.add(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorNombre(String nombre) {
        for(Usuario ac: usuarios)
            if(ac.getUsername().compareTo(nombre)==0)
                return ac;
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorIdFacebook(String idFacebook) {
        for(Usuario ac:usuarios)
            if(ac.getIdFacebook().compareTo(idFacebook)==0)
                return ac;
        return null;
    }

    @Override
    public void volverseAmigos(Usuario usuario1, Usuario usuario2) {
        boolean found = false;
        for(Usuario ac: usuario1.getAmigos())
            if(ac.getIdFacebook().compareTo(usuario2.getIdFacebook())==0)
                found=true;
        if(!found)
        {
            List<Usuario> amigosUs1 = usuario1.getAmigos();
            amigosUs1.add(usuario2);
            usuario1.setAmigos(amigosUs1);
        }
       found = false;
        for(Usuario ac: usuario2.getAmigos())
            if(ac.getIdFacebook().compareTo(usuario1.getIdFacebook())==0)
                found=true;
        if(!found)
        {
            List<Usuario> amigosUs2 = usuario2.getAmigos();
            amigosUs2.add(usuario1);
            usuario1.setAmigos(amigosUs2);
        }
        
    }

    @Override
    public void aniadirTiendaAUsuario(Usuario usuario, Tienda tienda) {
        boolean found = false;
        for(Tienda ac : usuario.getTiendaLike())
            if(ac.getIdFacebook().compareTo(tienda.getIdFacebook())==0)
                found = true;
        if(!found)
        {
            List<Tienda> tiendas = usuario.getTiendaLike();
            tiendas.add(tienda);
            usuario.setTiendaLike(tiendas);
        }
    }

    @Override
    public void aniadirCupon(Cupon cupon, Usuario usuario) {
        boolean inList=true;
        if(cupon.getIdCupon()==null)
            cupon.setIdCupon(generateIdCupon());
        while(inList)
        {
            inList=false;
            for(Cupon ac: cupones)
            {
                if(ac.getIdCupon().compareTo(cupon.getIdCupon())==0)
                    inList=true;
            }
            if(inList)
                cupon.setIdCupon(generateIdCupon());
        }
        cupones.add(cupon);
        List<Cupon> cuponesAc= cupon.getTienda().getListaCupones();
        cuponesAc.add(cupon);
        cupon.getTienda().setListaCupones(cuponesAc);
        List<Cupon> cuponesUsuario = usuario.getCupones();
        cuponesUsuario.add(cupon);
        usuario.setCupones(cuponesUsuario);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public List<Tienda> getTiendas() {
        return tiendas;
    }

    @Override
    public List<Cupon> getCupones() {
        return cupones;
    }
    /**
     * Genera un Id para cupones con alta probabilidad de ser unico
     * @return Un id para cupon
     */
    private String generateIdCupon(){
        long r=cupones.size()+1;
        for(int i=-5;i< Math.random()*10;i++)
            r=(r*r)%1020792161;
        r=(r*(this.hashCode()+1))%1000000007;
        return "Cup"+r+""+this.hashCode();
    }

    @Override
    public Cupon darCuponPorId(String idCupon) {
        for (Cupon ac : cupones)
            if(ac.getIdCupon().compareTo(idCupon)==0)
                return ac;
        return null;
    }

    @Override
    public boolean descontarDineroCupon(double dineroADescontar, Cupon cupon) {
        if(dineroADescontar> cupon.getSaldo())
            return false;
        cupon.setSaldo(cupon.getSaldo()-dineroADescontar);
        return true;                   
    }

    @Override
    public void aniadirTienda(Tienda tienda) {
        if(buscarTiendaPorId(tienda.getIdFacebook())==null)
            tiendas.add(tienda);
    }

    @Override
    public Tienda buscarTiendaPorId(String idTienda) {
        for(Tienda ac : tiendas)
            if(ac.getIdFacebook().compareTo(idTienda)==0)
                return ac;
        return null;
    }

    @Override
    public Tienda buscarTiendaPorNombre(String nombre) {
        for(Tienda ac: tiendas)
            if(ac.getNombre().compareTo(nombre)==0)
                return ac;
        return null;
    }
    
    public Usuario darUsuarioPrueba()
    {
        return usuarioPrueba;
    }
    
}
