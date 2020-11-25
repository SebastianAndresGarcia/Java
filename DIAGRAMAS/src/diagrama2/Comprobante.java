/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama2;

/**
 *
 * @author hp
 */
public class Comprobante{
    private char tipo;
    private int numero;
    private Fecha fecha;  //no hay new porque el comprobante no tiene pintado el rombo (AGREGACION)

    public Comprobante(char tipo, int numero, Fecha fecha) {//ahora sí se pone fecha como parámetro
        this.tipo = tipo;
        this.numero = numero;
        this.fecha = fecha;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
}
