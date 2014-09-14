
package pingroup.vos;

/**
 * Clase que representa los cupones en el sistema
 */
public class Cupon {
    
    /**
     * Atributo que indica si el cupon ya fue redimido
     */
    private boolean redimido;
    
    /**
     *  El saldo restante en el cupon
     */
    private double saldo;
    
    /**
     * El coste original del cupon
     */
    private double costo;
    
    /**
     * La tienda a la que pertenece el cupon
     */
    private Tienda tienda;

    public Cupon(boolean redimido, double saldo, double costo, Tienda tienda) {
        this.redimido = redimido;
        this.saldo = saldo;
        this.costo = costo;
        this.tienda = tienda;
    }
    
    
    public boolean isRedimido() {
        return redimido;
    }

    public void setRedimido(boolean redimido) {
        this.redimido = redimido;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    
    
}
