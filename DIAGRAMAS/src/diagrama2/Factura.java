/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama2;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Factura extends Comprobante {

    private double total;
    private ArrayList<Producto> mProducto=new ArrayList<>();
    private Cliente mCliente;    //tiene una asociacion con cliente que se llama mCliente

    public Factura(double total, Cliente mCliente, char tipo, int numero, Fecha fecha, Producto mProducto) {
        super(tipo, numero, fecha);
        this.total = total;
        this.mCliente = mCliente;
        this.mProducto.add(mProducto);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Producto> getmProducto() {
        return mProducto;
    }

    public void setmProducto(ArrayList<Producto> mProducto) {
        this.mProducto = mProducto;
    }

    public Cliente getmCliente() {
        return mCliente;
    }

    public void setmCliente(Cliente mCliente) {
        this.mCliente = mCliente;
    }

    public void setmProducto(Producto mProducto) {
        this.mProducto.add(mProducto);
    }
}
