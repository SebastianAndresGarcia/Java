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
public class main5 {

    public static void main(String[] args) {
        barcoaVela vela = new barcoaVela(80.7, 100);
        vela.setVelocidadMaxima(90);
        System.out.println("Velocidad promedio del velero :" + vela.getVelocidadPromedio());

        FordFalcon f1 = new FordFalcon(120.5, 140);
       
        f1.romperInercia();
        f1.setVelocidadMaxima(150);
   
        f1.addRueda(new Rueda(f1.getN_ruedas(),"FordFalconF1"));
        System.out.println("Veloc. Max: " + f1.getVelocidadMaxima());
       
        System.out.println("Falcon tiene " + (f1.getRueda().get(0).getRueda()) + " ruedas");
        Moto XR25 = new Moto(150.6, 170);
        System.out.println("moto Xr25 tiene " + XR25.getN_ruedas() + " y tiene una velocidad promedio de " + XR25.getVelocidadPromedio());
    }
}
