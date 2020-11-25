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
public class Boing747 extends Vehiculo{
    private int viajes;

    public Boing747(int viajes, double velocidadPromedio, int velocidadMaxima) {
        super(velocidadPromedio, velocidadMaxima);
        this.viajes = viajes;
    }
    public void despegar(){
        System.out.println("Avión despegando");
    }
    public void aterrizar(){
        System.out.println("Avión aterrizando");
    }
    public void agregarViaje(){
        System.out.println("Nuevo viaje");
    }
    
}
