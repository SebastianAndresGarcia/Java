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
class OrdenTrabajo {

    private int IDordentrabajo;
    private int IDpapel;
    private String TipoPapel;
    private String nombrePapel;
    private Pedido pedido;
    private ArrayList<Productos> productos=new ArrayList<>();

    public OrdenTrabajo(int IDordentrabajo, int IDpapel, String TipoPapel, String nombrePapel) {
        this.IDordentrabajo = IDordentrabajo;
        this.IDpapel = IDpapel;
        this.TipoPapel = TipoPapel;
        this.nombrePapel = nombrePapel;
    }

    public int getIDordentrabajo() {
        return IDordentrabajo;
    }

    public void setIDordentrabajo(int IDordentrabajo) {
        this.IDordentrabajo = IDordentrabajo;
    }

    public int getIDpapel() {
        return IDpapel;
    }

    public void setIDpapel(int IDpapel) {
        this.IDpapel = IDpapel;
    }

    public String getTipoPapel() {
        return TipoPapel;
    }

    public void setTipoPapel(String TipoPapel) {
        this.TipoPapel = TipoPapel;
    }

    public String getNombrePapel() {
        return nombrePapel;
    }

    public void setNombrePapel(String nombrePapel) {
        this.nombrePapel = nombrePapel;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }

    public void realiza() {

    }

    public void finaliza() {

    }
}
