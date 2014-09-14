/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.interfaces;

import pingroup.vos.Usuario;

/**
 * Interfaz que declara los servicios de persistencia
 */
public interface IServicioPersistenciaLocal {

   /**
    * Busca un usuario por su token
    * @param token El token por el que se quiere buscar
    * @return El usuario o null si no está registrado el usuario
    */
    public Usuario buscarPorToken(String token); 

    /**
     * Crea un usuario nuevo en el sistema con su token en facebook
     * @param token El token de facebook del usuario
     * @return El usuario nuevo
     */
    public Usuario crearUsuario(String token);
    
}
