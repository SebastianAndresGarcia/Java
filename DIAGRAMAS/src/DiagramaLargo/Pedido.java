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
class Pedido {
    private int IDpedido;
    private int IDordenTrabajo;
    private int IDcliente;

    public Pedido(int IDpedido, int IDordenTrabajo, int IDcliente) {
        this.IDpedido = IDpedido;
        this.IDordenTrabajo = IDordenTrabajo;
        this.IDcliente = IDcliente;
    }

    public int getIDpedido() {
        return IDpedido;
    }

    public void setIDpedido(int IDpedido) {
        this.IDpedido = IDpedido;
    }

    public int getIDordenTrabajo() {
        return IDordenTrabajo;
    }

    public void setIDordenTrabajo(int IDordenTrabajo) {
        this.IDordenTrabajo = IDordenTrabajo;
    }

    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }
    
    public void hace(){
        
    }
    public void ordena(){
        
    }
}
