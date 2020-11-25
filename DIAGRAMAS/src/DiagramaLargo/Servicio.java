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
class Servicio {
    private int IdServicio;
    private String TipoServicio;
    private String DescripcionServicio;
    private double precioVenta;

    public Servicio(int IdServicio, String TipoServicio, String DescripcionServicio, double precioVenta) {
        this.IdServicio = IdServicio;
        this.TipoServicio = TipoServicio;
        this.DescripcionServicio = DescripcionServicio;
        this.precioVenta = precioVenta;
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public String getTipoServicio() {
        return TipoServicio;
    }

    public void setTipoServicio(String TipoServicio) {
        this.TipoServicio = TipoServicio;
    }

    public String getDescripcionServicio() {
        return DescripcionServicio;
    }

    public void setDescripcionServicio(String DescripcionServicio) {
        this.DescripcionServicio = DescripcionServicio;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public void Realiza(){
        
    }
}
