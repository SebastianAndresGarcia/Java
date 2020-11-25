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
public class FordFalcon extends Auto{
    
    public FordFalcon(double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
    }

    @Override
    public void romperInercia() {
         System.out.println("FordFalcon rompe inercia!!"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
