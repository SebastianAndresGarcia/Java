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
public class Venta {
    private String IdVenta;
    private String Fecha;
    private String IdPedido;
    private String IdServicio;
    private String idproducto;
    private Servicio servicio;
    private Reporte reporte;
    private SistemaDePago sistemaDePago;

    public Venta(String IdVenta, String Fecha, String IdPedido, String IdServicio, String idproducto, Servicio servicio, Reporte reporte, SistemaDePago sistemaDePago) {
        this.IdVenta = IdVenta;
        this.Fecha = Fecha;
        this.IdPedido = IdPedido;
        this.IdServicio = IdServicio;
        this.idproducto = idproducto;
        this.servicio = servicio;
        this.reporte = reporte;
        this.sistemaDePago = sistemaDePago;
    }

    public String getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(String IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(String IdPedido) {
        this.IdPedido = IdPedido;
    }

    public String getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(String IdServicio) {
        this.IdServicio = IdServicio;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public SistemaDePago getSistemaDePago() {
        return sistemaDePago;
    }

    public void setSistemaDePago(SistemaDePago sistemaDePago) {
        this.sistemaDePago = sistemaDePago;
    }
    public void Realiza(){
        
    }
    public void Cancela(){
        
    }
    public void modifica(){
        
    }
}
