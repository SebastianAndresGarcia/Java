/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama7;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class main7 {

    public static void main(String[] args) {
        //Crear perfiles
        
        Foto fotoDetective = new Foto("c:\\picture", "frente", 350);
        //String numeroPlaca, String nombre, String apellido, Foto foto
        Detective detective1 = new Detective("5968", "Inspector John", "Smith", fotoDetective);
        Mafioso mafioso1 = new Mafioso("Don", "Corleone", new Foto("c:\\picture", "frente-perfil", 350));
        mafioso1.agregarLugar(new Lugar("Mansión IL padrino", new Direccion("Avenida italia", 345)));
        mafioso1.addsetComunicaciones(new MediodeComunicacion("Celular", new TipoMedio("MOVISTAR", "telefonoMovil")));
        Boolean tieneAntecedentes = mafioso1.investigar();
        Boolean investigueAmafioso = false;
        if (tieneAntecedentes) {
            investigueAmafioso = detective1.investigarMafioso(mafioso1);
            System.out.println("Sospechoso tiene Antecedentes\n\n");
        } else {
            System.out.println("sospechoso no tiene antecedentes");
        }
        
        if (investigueAmafioso) {
            System.out.println("Detective \n" + detective1.getNombre() + " " + detective1.getApellido()
                    + "Placa n° " + detective1.getNumeroPlaca() + " debe investigar a " + mafioso1.getNombre() + " " + mafioso1.getApellido());
            System.out.println();
            System.out.println("Ficha del sospechoso ");
            System.out.println("Nombre y apellido :" + mafioso1.getNombre() + " " + mafioso1.getApellido());
            System.out.println("Lugares Frecuentes: "
                    + mafioso1.getLugaresfrecuentes().get(0).getDireccion().getCalle() + " " + mafioso1.getLugaresfrecuentes().get(0).getDireccion().getNumeroDlio());
            System.out.println("Medio de Comunicacion: " + mafioso1.getComunicaciones().get(0).getDescripcion() + " "
                    + mafioso1.getComunicaciones().get(0).getTipomedio().getTipo() + " "
                    + mafioso1.getComunicaciones().get(0).getTipomedio().getNombreMedio());

        }

    }
}
