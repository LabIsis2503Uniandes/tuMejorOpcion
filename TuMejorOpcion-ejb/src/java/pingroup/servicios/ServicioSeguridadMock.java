/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.servicios;

import javax.ejb.Stateless;
import pingroup.excepciones.AutenticacionException;
import pingroup.interfaces.IServicioPersistenciaLocal;
import pingroup.interfaces.IServicioSeguridadLocal;
import pingroup.vos.Usuario;

/**
 * Un mock del servicio de seguridad
 */
@Stateless
public class ServicioSeguridadMock implements IServicioSeguridadLocal{

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    private IServicioPersistenciaLocal persistencia;
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioSeguridadMock()
    {
        persistencia=new ServicioPersistenciaMock();
    }
    
    /**
     * Método que se encarga de autenticar un usario en el sistema
     * @param token El token del usuario
     * @return El objeto del usuario
     * @throws AutenticacionException Retorna excepcion si hubo algún problema
     */
    @Override
    public Usuario ingresar(String token) throws AutenticacionException {
        Usuario r = persistencia.buscarUsuarioPorToken(token);
        if(r!=null)
            return r;
        else
        {
            //MARICO TODO
            //TODO
            //EMANUEL ES UN MARICO
            //SUPER TODO
            
            //EN SERIO TODO
            return null;
        }
    }
    
}
