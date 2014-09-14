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
    
    public ServicioPersistenciaMock() {
        cupones = new  ArrayList<Cupon>();
        tiendas = new  ArrayList<Tienda>();
        usuarios = new ArrayList<Usuario>();
    }

    @Override
    public Usuario buscarPorToken(String token) {
        for (Usuario ac: usuarios)
        {
            if(ac.getTokenFacebook().compareTo(token)==0)
                return ac;
        }
        return null;
    }

    @Override
    public Usuario crearUsuario(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
