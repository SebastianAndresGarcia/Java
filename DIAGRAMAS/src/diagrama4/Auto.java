/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama4;

/**
 *
 * @author hp
 */
public class Auto extends Vehiculo implements Motor {

    private int puertas;

    public Auto(int puertas, int ruedas, String duenio) {
        super(ruedas, duenio);
        this.puertas = puertas;
    }

    @Override
    public double Precio(double valor) {
        System.out.print("El precio de la moto es: $");
       return valor;
    }

    @Override
    public double velocMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRuedas() {
        return ruedas;
    }

    @Override
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public void Tipo() {

        System.out.println("Tipo de motor: 1.6");
    }

}
