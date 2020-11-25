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
public class main {
     public static void main(String[] args) {
                         //ruedas dueño
         Moto M1= new Moto(0,"Sebastian");
         M1.Tipo(); 
         M1.setRuedas(2);
         System.out.println(M1.velocMax());
         System.out.println(M1.Precio(1000));
         System.out.println("cantidad ruedas "+M1.getRuedas());
         M1.setDuenio("GUSTAVO");
         System.out.println("dueño "+M1.getDuenio());
          
     }
}
