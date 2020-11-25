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
public class Bicicleta extends Vehiculo {

    public Bicicleta(int ruedas, String duenio) {
        super(ruedas, duenio);
    }

    @Override
    public double Precio(double valor) {
        System.out.print("El precio de la moto es: $");
       return valor;
    }

    @Override
    public double velocMax() {
        System.out.print("La velocidad máx ");
        return 35;
    }

    @Override
    public int getRuedas() {
        return ruedas;
    }

    @Override
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

   
}
