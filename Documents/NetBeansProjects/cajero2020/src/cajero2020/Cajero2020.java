/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero2020;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class Cajero2020 {

    public static void main(String[] args) {

        String usuario = "seba", contraseña = "1234", u, c;
        Scanner sn = new Scanner(System.in);
        int opcion;
        double saldo1 = 100000; //saldo total
        ArrayList<Double> saldo = new ArrayList<Double>(); //saldo parcial según cada movimiento
        ArrayList<String> registro = new ArrayList<String>(); //nombra qué acción realizó
        ArrayList<Double> ultmov = new ArrayList<Double>(); //registra el saldo actual en función de los movimientos
        boolean salir = false;//https://www.discoduroderoer.es/como-hacer-un-menu-de-opciones-en-consola-en-java/

        do {
            System.out.println("Ingrese su nombre de Usuario");
            Scanner S = new Scanner(System.in);
            u = S.next();
            if (u.equals("0")) {
                System.out.println("Gracias por usar nuestro sistema");
                System.exit(0);
            } else if (!usuario.equals(u)) {
                System.out.println("Usuario no válido, intente nuevamente");
                System.out.print("\n");
            }
        } while (!usuario.equals(u));
        do {
            System.out.println("Ingrese su Contraseña");
            Scanner S = new Scanner(System.in);
            c = S.next();
            if (!contraseña.equals(c)) {
                System.out.println("contraseña incorrecta, intente nuevamente");
                System.out.println("\n");
            }
        } while (!contraseña.equals(c));

        System.out.println("Bienvenido " + usuario);
        System.out.println("\n");
        System.out.println("Elija una opción");

        while (!salir) {
            try {
                menu();

                opcion = sn.nextInt();
                if (opcion == 0) {
                    System.out.println("Gracias por utilizar nuestro sistema");
                    System.exit(0);
                }
                switch (opcion) {
                    case 1:
                        saldo1 = depositar(opcion, registro, ultmov, saldo1, saldo);
                        break;
                    case 2:
                        System.out.println("2-Sacar Plata");
                        double extraer_1;

                        do {

                            System.out.println("Limite minimo de extraccion: 100 pesos por operacion");
                            System.out.println("\n");
                            System.out.println("Limite maximo de extraccion: 5000 pesos por operacion");
                            System.out.println("\n");
                            System.out.println("ingrese el monto que desea extraer: ");
                            do {
                                try {
                                    Scanner s = new Scanner(System.in);
                                    extraer_1 = s.nextFloat();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("ingrese solo numeros, cuanto desea extraer: ");
                                }
                            } while (true);

                            if (extraer_1 > saldo1) {
                                System.out.println("No cuenta con fondos suficientes para realizar esta operación");
                                System.out.println("\n");
                                System.out.println("Su saldo es: ");
                                System.out.println(saldo1);
                            }
                        } while (extraer_1 < 99 || extraer_1 > 5000 || extraer_1 > saldo1);
                        registro.add("extraccion: ");
                        ultmov.add(extraer_1);
                        saldo1 = saldo1 - ultmov.get(ultmov.size() - 1);
                        saldo.add(saldo1);

                        System.out.println("DINERO EXTRAIDO");
                        System.out.println("saldo: " + saldo1);
                        break;
                    case 3:
                        System.out.println("Su saldo es:  ");
                        System.out.println(+saldo1);
                        break;
                    case 4:
                        System.out.println("4-ACCIONES REALIZADAS");
                        System.out.println("Tipo de movimiento");
                        System.out.println("\n");
                        for (int j = 0; j < registro.size(); j++) {
                            System.out.println(registro.get(j) + " " + ultmov.get(j) + "   Saldo: " + saldo.get(j));
                        }
                        break;
                    case 5:
                        System.out.println("Hasta pronto, gracias por utilizar nuestro sistema");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    private static void menu() {
        System.out.println("\n");
        System.out.println("Elija una opción para continuar------------------------------Presione 0 para salir del sistema");
        System.out.println("1-Depositar");
        System.out.println("\n");
        System.out.println("2-Sacar Plata");
        System.out.println("\n");
        System.out.println("3-Mostrar saldo");
        System.out.println("\n");
        System.out.println("4-Acciones realizadas");
        System.out.println("\n");
        System.out.println("5-Salir");
    }

    public static double depositar(int opcion, ArrayList<String> registro, ArrayList<Double> ultmov, double saldo1, ArrayList<Double> saldo) {
        double deposito_1 = 0;
        System.out.println("1-Depositar");

        do {
            System.out.println("Limite minimo de deposito 100 pesos por operacion");
            System.out.println("\n");
            System.out.println("Limite máximo de depósito: 5000 pesos por operacion");
            System.out.println("\n");
            System.out.println("ingrese su depósito: ");
            do {
                try {
                    Scanner S = new Scanner(System.in);
                    deposito_1 = S.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("ingrese solo numeros, su depósito: ");
                }
            } while (true);
        } while ((deposito_1) < 99 || (deposito_1) > 5000);

        registro.add("deposito: ");
        ultmov.add(deposito_1);
        saldo1 = saldo1 + ultmov.get(ultmov.size() - 1);
        saldo.add(saldo1);

        System.out.println("DINERO DEPOSITADO");
        System.out.println("saldo: " + saldo1);
        return (saldo1);
    }
}
