/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.vos;

import java.util.List;

/**
 * Clase que representa una Tienda inscrita en el sistema
 */
public class Tienda {
    
    /**
     * El nombre de la tienda inscrita en el sistema
     */
    private String nombre;
    
    /**
     * El id de la tienda en Facebook
     */
    private String idFacebook;
    
    /**
     * La URL de la tienda en Facebook
     */
    private String URLFaccebook;
    
    /**
     * La lista de cupones que tiene la tienda
     */
    private List<Cupon> listaCupones;

    public Tienda(String nombre, String idFacebook, String URLFaccebook, List<Cupon> listaCupones) {
        this.nombre = nombre;
        this.idFacebook = idFacebook;
        this.URLFaccebook = URLFaccebook;
        this.listaCupones = listaCupones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

    public String getURLFaccebook() {
        return URLFaccebook;
    }

    public void setURLFaccebook(String URLFaccebook) {
        this.URLFaccebook = URLFaccebook;
    }

    public List<Cupon> getListaCupones() {
        return listaCupones;
    }

    public void setListaCupones(List<Cupon> listaCupones) {
        this.listaCupones = listaCupones;
    }

    
}

