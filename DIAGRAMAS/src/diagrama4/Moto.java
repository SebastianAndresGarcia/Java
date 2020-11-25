/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama4;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Moto extends Vehiculo implements Motor {

    public Moto(int ruedas, String duenio) {
        super(ruedas, duenio);
    }

    @Override
    public int getRuedas() {
        return ruedas;
    }

    @Override
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String getDuenio() {
        return duenio;
    }

    @Override
    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    @Override
    public double Precio(double valor) {
        System.out.print("El precio de la moto es: $");
       return valor;
    }

    @Override
    public double velocMax() {
        System.out.println("Ingrese la velocidad max ");
        Scanner S= new Scanner(System.in);
        
        double veloc=S.nextDouble();
        System.out.print("La velocidad máx ");
        return (veloc);
    }

   
    public void Tipo() {
        System.out.println("Ingrese el tipo de motor en cc");
        Scanner s=new Scanner(System.in);
        String tipo=s.nextLine();
        System.out.println("Tipo de motor: "+tipo);
    }
    
}
