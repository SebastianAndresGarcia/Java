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
class Cliente {
    private int IDcliente;
    private String RazonSocial;
    private String NombreCliente;
    private String ApellidoCliente;
    private String TelefonoCliente;
    private int CPCliente;
    private String calle;
    private String nrodlio;
    private String Localidad;
    private Factura factura;
    private ArrayList<Pedido> pedido=new ArrayList<>();
    private ArrayList<Cotizacion> cotizacion=new ArrayList<>();
    
    
    public Cliente(int IDcliente, String RazonSocial, String NombreCliente, String ApellidoCliente, String TelefonoCliente, int CPCliente, String calle, String nrodlio, String Localidad) {
        this.IDcliente = IDcliente;
        this.RazonSocial = RazonSocial;
        this.NombreCliente = NombreCliente;
        this.ApellidoCliente = ApellidoCliente;
        this.TelefonoCliente = TelefonoCliente;
        this.CPCliente = CPCliente;
        this.calle = calle;
        this.nrodlio = nrodlio;
        this.Localidad = Localidad;
    }

    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getApellidoCliente() {
        return ApellidoCliente;
    }

    public void setApellidoCliente(String ApellidoCliente) {
        this.ApellidoCliente = ApellidoCliente;
    }

    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(String TelefonoCliente) {
        this.TelefonoCliente = TelefonoCliente;
    }

    public int getCPCliente() {
        return CPCliente;
    }

    public void setCPCliente(int CPCliente) {
        this.CPCliente = CPCliente;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNrodlio() {
        return nrodlio;
    }

    public void setNrodlio(String nrodlio) {
        this.nrodlio = nrodlio;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Cotizacion> getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(ArrayList<Cotizacion> cotizacion) {
        this.cotizacion = cotizacion;
    }
    
    public void Compra(){
        
    }
    public void UsaServicios(){
        
    }
}
