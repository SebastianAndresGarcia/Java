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
public class HondaXR25 extends Moto{

    public HondaXR25(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }
    
    @Override
    public void esquivarObstaculo(int metros) {
        System.out.println("Moto XR25 Avanzó "+ metros+" esquivando obstáculos");
    }
}
