/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.vos;

import java.util.List;

/**
 * La clase que representa un usuario dentro del sistema
 */
public class Usuario {
    /**
     * El username del usuario
     */
    private String username;
    
    /**
     * El id del usuario dentro de Facebook
     */
    private String idFacebook;
    
    /**
     * El correo del usuario
     */
    private String correo;
    
    /**
     * El token de acceso de Facebook
     */
    private String tokenFacebook;

    /**
     * La lista de cupones que tiene el usuario
     */
    private List<Cupon> cupones;
    
    /**
     * La lista de tiendas que le gustan al usuario
     */
    private List<Tienda> tiendaLike;
    
    /**
     * La lista de amigos del usuario 
     */
    private List<Usuario> amigos;

    public Usuario(String username, String idFacebook, String correo, String tokenFacebook, List<Cupon> cupones, List<Tienda> tiendaLike, List<Usuario> amigos) {
        this.username = username;
        this.idFacebook = idFacebook;
        this.correo = correo;
        this.tokenFacebook = tokenFacebook;
        this.cupones = cupones;
        this.tiendaLike = tiendaLike;
        this.amigos = amigos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTokenFacebook() {
        return tokenFacebook;
    }

    public void setTokenFacebook(String tokenFacebook) {
        this.tokenFacebook = tokenFacebook;
    }

    public List<Cupon> getCupones() {
        return cupones;
    }

    public void setCupones(List<Cupon> cupones) {
        this.cupones = cupones;
    }

    public List<Tienda> getTiendaLike() {
        return tiendaLike;
    }

    public void setTiendaLike(List<Tienda> tiendaLike) {
        this.tiendaLike = tiendaLike;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }
    
    
}
