/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaLargo;

/**
 *
 * @author hp
 */
class DetalleFactura {
    private int IDfactura;
    private int IDproductos;
    private int CantProductos;
    private double Subtotal;
    private double IVA;
    private double Total;

    public DetalleFactura(int IDfactura, int IDproductos, int CantProductos, double Subtotal, double IVA, double Total) {
        this.IDfactura = IDfactura;
        this.IDproductos = IDproductos;
        this.CantProductos = CantProductos;
        this.Subtotal = Subtotal;
        this.IVA = IVA;
        this.Total = Total;
    }

    public int getIDfactura() {
        return IDfactura;
    }

    public void setIDfactura(int IDfactura) {
        this.IDfactura = IDfactura;
    }

    public int getIDproductos() {
        return IDproductos;
    }

    public void setIDproductos(int IDproductos) {
        this.IDproductos = IDproductos;
    }

    public int getCantProductos() {
        return CantProductos;
    }

    public void setCantProductos(int CantProductos) {
        this.CantProductos = CantProductos;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
}
