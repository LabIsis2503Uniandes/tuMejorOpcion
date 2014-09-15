/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.servicios;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pingroup.interfaces.IServicioMenuUsuarioLocal;
import pingroup.interfaces.IServicioPersistenciaLocal;
import pingroup.vos.Cupon;
import pingroup.vos.Tienda;
import pingroup.vos.Usuario;

/**
 *Servicio de el menu de usuario
 */
@Stateless
public class ServicioMenuUsuarioMock implements IServicioMenuUsuarioLocal{
    
    /**
     * Servicio de persistencia
     */
    @EJB
    private IServicioPersistenciaLocal servicio;
    
    public ServicioMenuUsuarioMock(){
        
    }

    @Override
    public void crearCupon(Usuario usr, Tienda tienda, int saldo) {
        Cupon cup = new Cupon(false, saldo, saldo, tienda, null);
        servicio.aniadirCupon(cup, usr);
    }

    @Override
    public List<Tienda> darTiendas() {
        return servicio.getTiendas();
    }


    
}
