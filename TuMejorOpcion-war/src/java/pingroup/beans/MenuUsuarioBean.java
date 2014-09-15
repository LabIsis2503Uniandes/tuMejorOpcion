/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingroup.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import pingroup.interfaces.IServicioMenuUsuarioLocal;
import pingroup.vos.Cupon;
import pingroup.vos.Tienda;
import pingroup.vos.Usuario;

/**
 * @author Banana
 */
public class MenuUsuarioBean implements Serializable{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Servicio del menu de usuario
     */
    @EJB
    private IServicioMenuUsuarioLocal servicio;
    /**
     * Usuario loggeado en la aplicacion
     **/
    private Usuario usuario;
   
    /**
     * Lista de amigos del usuario
     */
    private List <Usuario> amigos;
    
    /**
     * Lista de bonos del usuario
     */
    private List <Cupon> cupones;
    
    /**
     * Cupon que se va a crear
     */
    private int saldo;
    
    /**
     * La tienda que se va a asociar al cupon
     */
    private Tienda tienda;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public MenuUsuarioBean()
    {
        saldo = 0;
        tienda =  new Tienda();
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("loginBean"))
        {
            LoginBean sessionSecurity = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
            usuario = sessionSecurity.getUsuario();
            amigos = usuario.getAmigos();
            cupones = usuario.getCupones();
        }
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el efecto de la tabla del carrito
     * @return efectoTablaCarrito Efecto
     */
    public String getNombreUsuario()
    {
        if (usuario!= null)
            return usuario.getUsername();
        return "Nombre no Disponible";
    }
    
    /**
     * Devuelve la lista de amigos 
     * @return la lista de amigos del usuario
     */
    public List<Usuario> getAmigos()
    {
        return amigos;
    }
    
    /**
     * Devuelve la lista de cupones que tiene el usuario
     * @return la lista de Cupones del usuario
     */
    
    public List<Cupon> getCupones()
    {
        return cupones;
    }
    
    /**
     * Retorna el saldo que tiene el bean
     * @return saldo, el saldo del Bean
     */
    public int getSaldo()
    {
        return saldo;
    }
    
    /**
     * Setea el saldo
     * @param saldo, el nuevo saldo
     */
    public void setSaldo( int saldo)
    {
        this.saldo = saldo;
    }
    
     /**
     * Retorna la tienda que tiene el bean
     * @return tienda, la tienda del Bean
     */
    public Tienda getTienda()
    {
        return tienda;
    }
    
    /**
     * Setea la tienda
     * @param tienda, la nueva tienda
     */
    public void setTienda( Tienda tienda)
    {
        this.tienda = tienda;
    }
    
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------

    /**
     * Crea un cupon para el usuario
     */
    public void crearCupon()
    {
        servicio.crearCupon(usuario, tienda, saldo);
        tienda = new Tienda();
        saldo = 0;
    }
    
    /**
     * Retorna las tiendas en el sistema
     * @return tiendas del sistema
     */
    public List<Tienda> darTiendas()
    {
        return servicio.darTiendas();
    }
    
}
