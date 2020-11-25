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
class Cotizacion {
    private int IDproducto;
    private int IDservicio;
    private int IDcliente;
    private int IDempleado;
    private Productos producto;
    private Cliente cliente;
    private Servicio servicio;
    private DetalleCotizacion detalleCotizacion;
    
    public Cotizacion(int IDproducto, int IDservicio, int IDcliente, int IDempleado) {
        this.IDproducto = IDproducto;
        this.IDservicio = IDservicio;
        this.IDcliente = IDcliente;
        this.IDempleado = IDempleado;
    }

    public int getIDproducto() {
        return IDproducto;
    }

    public void setIDproducto(int IDproducto) {
        this.IDproducto = IDproducto;
    }

    public int getIDservicio() {
        return IDservicio;
    }

    public void setIDservicio(int IDservicio) {
        this.IDservicio = IDservicio;
    }

    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }

    public int getIDempleado() {
        return IDempleado;
    }

    public void setIDempleado(int IDempleado) {
        this.IDempleado = IDempleado;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    public void hace(){
        
    }
    public void aprueba(){
        
    }
    public void rechaza(){
        
    }
}
