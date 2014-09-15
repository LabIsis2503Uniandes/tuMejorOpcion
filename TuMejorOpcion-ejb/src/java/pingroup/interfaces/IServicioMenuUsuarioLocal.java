/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.interfaces;

import java.util.List;
import pingroup.vos.Cupon;
import pingroup.vos.Tienda;
import pingroup.vos.Usuario;

/**
 *
 * @author Banana
 */
public interface IServicioMenuUsuarioLocal {
    
    /**
     * Método que se encarga de crear un cupon nuevo para un usuario
     * @param usr, el usuario al que se le va a crear el cupon
     * @param tienda la tienda para la cual se va a crear el cupon
     * @param saldo el saldo que se le va a poner al cupon
     */
    public void crearCupon(Usuario usr, Tienda tienda, int saldo);
    
    /**
     * Método que retorna las tiendas que estan en el sistema
     * @return tiendas, las tiendas del sistema
     */
    public List<Tienda> darTiendas();
    

    
    
}
