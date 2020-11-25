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
public class DetalleVenta {
    private Venta venta;
    private int IdVenta;
    private int IDProducto;
    private int CantidadProdutos;
    private String DescripcionVenta;

    public DetalleVenta(Venta venta, int IdVenta, int IDProducto, int CantidadProdutos, String DescripcionVenta) {
        this.venta = venta;
        this.IdVenta = IdVenta;
        this.IDProducto = IDProducto;
        this.CantidadProdutos = CantidadProdutos;
        this.DescripcionVenta = DescripcionVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getCantidadProdutos() {
        return CantidadProdutos;
    }

    public void setCantidadProdutos(int CantidadProdutos) {
        this.CantidadProdutos = CantidadProdutos;
    }

    public String getDescripcionVenta() {
        return DescripcionVenta;
    }

    public void setDescripcionVenta(String DescripcionVenta) {
        this.DescripcionVenta = DescripcionVenta;
    }
    
}
