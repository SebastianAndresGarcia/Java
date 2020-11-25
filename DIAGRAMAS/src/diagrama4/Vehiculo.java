/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edi tor.
 */
package diagrama4;

/**
 *
 * @author hp
 */
public abstract class Vehiculo {

    protected int ruedas;
    protected String duenio;

    public abstract double Precio(double valor);
    public abstract double velocMax();

    public Vehiculo(int ruedas, String duenio) {
        this.ruedas = ruedas;
        this.duenio = duenio;
    }

    public abstract int getRuedas();

    public abstract void setRuedas(int ruedas);

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }
   
}
