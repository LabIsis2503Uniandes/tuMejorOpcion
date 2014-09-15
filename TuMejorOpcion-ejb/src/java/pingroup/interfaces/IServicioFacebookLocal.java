/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.interfaces;

import java.util.ArrayList;
import java.util.List;
import pingroup.vos.Tienda;


/**
 * Interfaz que declara los servicios de persistencia
 */
public interface IServicioFacebookLocal {

    /**
     * Retorna la tiendas 
     * @param token
     * @return 
     */
    public List<Tienda> getTiendasEnLikes(String token)throws Exception;
    
}
