/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author hp
 */
public class Calculos{

    private double valor1, valor2;
    private String operacion;

    public Calculos() {
    }

    public Calculos(double valor1, double valor2, String operacion) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.operacion = operacion;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    private double sumarNumeros() {
        return this.valor1 + this.valor2;
    }

    private double restarNumeros() {
        return this.valor1 - this.valor2;
    }

    private double multiplicarNumeros() {
        return this.valor1 * this.valor2;
    }

    private double dividirNumeros() {
        return this.valor1 / this.valor2;
    }

    public double aplicarOperacion(String operacion) {
        switch (operacion) {
            case "+":
                return sumarNumeros();
            case "-":
                return restarNumeros();
            case "*":
                return multiplicarNumeros();
            case "/":
                return dividirNumeros();
            default:
                break;
        }
        return 0;
    }

}
