/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama5;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Vehiculo implements Desplazable {

    private double velocidadPromedio;
    private int velocidadMaxima;
    private ArrayList<Rueda> rueda=new ArrayList();

    public Vehiculo(double velocidadPromedio, int velocidadMaxima) {
        this.velocidadPromedio = velocidadPromedio;
        this.velocidadMaxima = velocidadMaxima;
    }

    public ArrayList<Rueda> getRueda() {
        return rueda;
    }

    public void setRueda(ArrayList<Rueda> rueda) {
        this.rueda = rueda;
    }
    public void addRueda(Rueda rueda){
        this.rueda.add(rueda);
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void romperInercia() {
        System.out.println("rompió inercia");
    }

    
    @Override
    public void esquivarObstaculo(int metros) {
       System.out.println("Avanzó esquivando obstáculos");
    }

}
