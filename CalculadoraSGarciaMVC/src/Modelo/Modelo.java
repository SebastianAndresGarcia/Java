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
public class Modelo {

    private Calculos c1=new Calculos();
    private String cuenta;
    private String nro1;
    private String nro2;
    private String operador;
    private boolean signo1;
    private boolean signo2;
    private boolean opeAsignado;

    public Modelo(String cuenta, String nro1, String nro2, String operador, boolean signo1, boolean signo2, boolean opeAsignado) {
        
        this.cuenta = "";
        this.nro1 = "";
        this.nro2 = "";
        this.operador = "";
        this.signo1 = false;
        this.signo2 = false;
        this.opeAsignado = false;
    }

    public Modelo() {
       
    }
    
// private Calculos c1 = new Calculos();
//    private String cuenta = "";
//    private String nro1 = "", nro2 = "";
//    private String operador = "";
//    private boolean signo1 = false, signo2 = false;
//    private boolean opeAsignado = false;

    public Calculos getC1() {
        return c1;
    }

    public void setC1(Calculos c1) {
        this.c1 = c1;
    }
    
    

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNro1() {
        return nro1;
    }

    public void setNro1(String nro1) {
        this.nro1 = nro1;
    }

    public String getNro2() {
        return nro2;
    }

    public void setNro2(String nro2) {
        this.nro2 = nro2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public boolean isSigno1() {
        return signo1;
    }

    public void setSigno1(boolean signo1) {
        this.signo1 = signo1;
    }

    public boolean isSigno2() {
        return signo2;
    }

    public void setSigno2(boolean signo2) {
        this.signo2 = signo2;
    }

    public boolean isOpeAsignado() {
        return opeAsignado;
    }

    public void setOpeAsignado(boolean opeAsignado) {
        this.opeAsignado = opeAsignado;
    }

 
    public boolean validarOperacion(String nro1, String nro2) {
        boolean valido = true;
        if (nro1.equals("") || nro2.equals("")) {
            valido = false;
        }
        return valido;
    }
}
//    class Calculos {
//
//        private double valor1, valor2;
//        private String operacion;
//
//        public Calculos() {
//        }
//
//        public Calculos(double valor1, double valor2, String operacion) {
//            this.valor1 = valor1;
//            this.valor2 = valor2;
//            this.operacion = operacion;
//        }
//
//        public double getValor1() {
//            return valor1;
//        }
//
//        public void setValor1(double valor1) {
//            this.valor1 = valor1;
//        }
//
//        public double getValor2() {
//            return valor2;
//        }
//
//        public void setValor2(double valor2) {
//            this.valor2 = valor2;
//        }
//
//        public String getOperacion() {
//            return operacion;
//        }
//
//        public void setOperacion(String operacion) {
//            this.operacion = operacion;
//        }
//
//        private double sumarNumeros() {
//            return this.valor1 + this.valor2;
//        }
//
//        private double restarNumeros() {
//            return this.valor1 - this.valor2;
//        }
//
//        private double multiplicarNumeros() {
//            return this.valor1 * this.valor2;
//        }
//
//        private double dividirNumeros() {
//            return this.valor1 / this.valor2;
//        }
//
//        public double aplicarOperacion(String operacion) {
//            switch (operacion) {
//                case "+":
//                    return sumarNumeros();
//                case "-":
//                    return restarNumeros();
//                case "*":
//                    return multiplicarNumeros();
//                case "/":
//                    return dividirNumeros();
//                default:
//                    break;
//            }
//            return 0;
//        }
//
//    }