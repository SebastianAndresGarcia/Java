/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama5;

/**
 *
 * @author hp
 */
class Moto extends Vehiculo{
    final int N_ruedas=2;

    public Moto(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }

    public int getN_ruedas() {
        return N_ruedas;
    }
    
}
