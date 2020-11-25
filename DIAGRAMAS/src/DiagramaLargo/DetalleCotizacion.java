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
class DetalleCotizacion {
    private int IDproductos;
    private int CantProductos;
    private double precios;

    public DetalleCotizacion(int IDproductos, int CantProductos, double precios) {
        this.IDproductos = IDproductos;
        this.CantProductos = CantProductos;
        this.precios = precios;
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

    public double getPrecios() {
        return precios;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
    }
    
}
