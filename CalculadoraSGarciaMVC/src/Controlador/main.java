/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Calculadora;


/**
 *
 * @author hp
 */
public class main {
      public static void main(String[] args) {
         //nuevas instancias de clase
        Modelo modelo = new Modelo("", "", "", "", false, false, false);
        Calculadora vista = new Calculadora();
        Controlador controlador = new Controlador( vista , modelo );
    }    
}
