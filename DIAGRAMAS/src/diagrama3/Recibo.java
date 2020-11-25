/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama3;

/**
 *
 * @author hp
 */
public class Recibo extends Comprobante{
    private Proveedor proveedor=new Proveedor(0," ");
    private double total;
    private String detalle;

    public Recibo(Proveedor proveedor, double total, String detalle, char tipo, int numero, Fecha fecha) {
        super(tipo, numero, fecha);
        this.proveedor = proveedor;
        this.total = total;
        this.detalle = detalle;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
}
