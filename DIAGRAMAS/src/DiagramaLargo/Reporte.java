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
class Reporte {
    private int Idreporte;
    private int NroReporte;
    private int IdPedido;
    private int IdCompra;
    private int IdVenta;

    public Reporte(int Idreporte, int NroReporte, int IdPedido, int IdCompra, int IdVenta) {
        this.Idreporte = Idreporte;
        this.NroReporte = NroReporte;
        this.IdPedido = IdPedido;
        this.IdCompra = IdCompra;
        this.IdVenta = IdVenta;
    }

    public int getIdreporte() {
        return Idreporte;
    }

    public void setIdreporte(int Idreporte) {
        this.Idreporte = Idreporte;
    }

    public int getNroReporte() {
        return NroReporte;
    }

    public void setNroReporte(int NroReporte) {
        this.NroReporte = NroReporte;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int IdPedido) {
        this.IdPedido = IdPedido;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }
    
    public void Realiza(){
        
    }
}
