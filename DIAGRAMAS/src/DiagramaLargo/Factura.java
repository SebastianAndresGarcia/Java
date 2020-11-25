/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaLargo;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
class Factura {

    private int IDfactura;
    private int IDCliente;
    private int IDVenta;
    private String Fecha;
    private String Hora;
    private OrdenTrabajo ordenTrabajo;
    private ArrayList<Productos> productos=new ArrayList<>();
    private DetalleFactura detalleFactura;
    
    public Factura(int IDfactura, int IDCliente, int IDVenta, String Fecha, String Hora) {
        this.IDfactura = IDfactura;
        this.IDCliente = IDCliente;
        this.IDVenta = IDVenta;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }

    public int getIDfactura() {
        return IDfactura;
    }

    public void setIDfactura(int IDfactura) {
        this.IDfactura = IDfactura;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }

    public void realiza() {

    }

    public void entrega() {

    }

}
