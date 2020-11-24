/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Calculadora;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author hp
 */
public class Controlador implements ActionListener {

    //nuevas instancias de clase
    Modelo modelo;
    Calculadora vista;

    Controlador(Calculadora vista, Modelo modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setVisible(true);

        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.vista.jButton3.addActionListener(this);
        this.vista.jButtonCuatro.addActionListener(this);
        this.vista.jButtonCinco.addActionListener(this);
        this.vista.jButtonSeis.addActionListener(this);
        this.vista.jButtonSiete.addActionListener(this);
        this.vista.jButtonOcho.addActionListener(this);
        this.vista.jButtonNueve.addActionListener(this);
        this.vista.jButtonLimpiar.addActionListener(this);
        this.vista.jButton11IgualA.addActionListener(this);
        this.vista.jButton14Suma.addActionListener(this);
        this.vista.jButton15Resta.addActionListener(this);
        this.vista.jButton16Division.addActionListener(this);
        this.vista.jButton17Producto.addActionListener(this);
        this.vista.jButton9COMA.addActionListener(this);
        this.vista.jButtonCero.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vista.jButton1)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "1");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButton2)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "2");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButton3)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "3");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButtonCuatro)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "4");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButtonCinco)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "5");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButtonSeis)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "6");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButtonSiete)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "7");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButtonOcho)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "8");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButtonNueve)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "9");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButtonCero)) {
            this.modelo.setCuenta(this.modelo.getCuenta() + "0");
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
        } else if (e.getSource().equals(this.vista.jButton11IgualA)) {
            int signo = 1, signo2 = 1;

            if (!this.modelo.getCuenta().equals("")) {

                for (int i = 0; i < this.modelo.getCuenta().length(); i++) {
                    if (this.modelo.getOperador().equals("")) {
                        if (i == 0 && this.modelo.getCuenta().charAt(i) == '-') {

                            signo = -1;
                        } else if (this.modelo.getCuenta().charAt(i) != ('-') && this.modelo.getCuenta().charAt(i) != ('+') && this.modelo.getCuenta().charAt(i) != ('*') && this.modelo.getCuenta().charAt(i) != ('/')) {
                            this.modelo.setNro1(this.modelo.getNro1() + this.modelo.getCuenta().charAt(i));
                        } else {
                            this.modelo.setOperador(this.modelo.getOperador() + this.modelo.getCuenta().charAt(i));

                        }
                    } else if (this.modelo.getCuenta().charAt(i) == '-') {
                        signo2 = -1;

                    } else if (this.modelo.getCuenta().charAt(i) != ('-') && this.modelo.getCuenta().charAt(i) != ('+') && this.modelo.getCuenta().charAt(i) != ('*') && this.modelo.getCuenta().charAt(i) != ('/')) {
                        this.modelo.setNro2(this.modelo.getNro2() + this.modelo.getCuenta().charAt(i));

                    }
                }
                if (this.modelo.validarOperacion(this.modelo.getNro1(), this.modelo.getNro2())) {
                    double numero1 = Double.parseDouble(this.modelo.getNro1());
                    this.modelo.getC1().setValor1(numero1 * signo);
                    this.modelo.getC1().setValor2(Double.parseDouble(this.modelo.getNro2()) * signo2);
                    this.modelo.getC1().setOperacion(this.modelo.getOperador());
                    this.vista.jText2Resultado.setText(Double.toString(this.modelo.getC1().aplicarOperacion(this.modelo.getC1().getOperacion())));
                    //this.jText1Operacion.setText(Double.toString(numero1) + operador + Double.toString(Double.parseDouble(nro2) * signo2));

                } else {
                    this.vista.jText2Resultado.setText("operacion invalida, presione limpiar p/continuar");
                }
            }

        } else if (e.getSource().equals(this.vista.jButton14Suma)) {
            while (!this.modelo.isOpeAsignado()) {
                if (this.modelo.getCuenta().equals("")) {
                    this.vista.jText2Resultado.setText("Primero debe ingresar numeros");
                } else if (this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('+')
                        || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('*')
                        || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('/')) {
                    this.vista.jText2Resultado.setText("Error, dos operadores aritmeticos consecutivos");
                } else {
                    this.modelo.setCuenta(this.modelo.getCuenta() + "+");
                    this.modelo.setOpeAsignado(true);
                }

                this.vista.jText1Operacion.setText(this.modelo.getCuenta());
                break;
            }
        } else if (e.getSource().equals(this.vista.jButton15Resta)) {
            if (this.modelo.getCuenta().equals("")) {
                this.modelo.setCuenta(this.modelo.getCuenta() + "-");
                this.vista.jText1Operacion.setText(this.modelo.getCuenta());
                this.modelo.setSigno1(true);
            } else if ((this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('-') || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1)
                    == ('+') || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('*') || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('/')) && this.modelo.isSigno2() == false && this.modelo.isOpeAsignado() == true) {
                this.modelo.setCuenta(this.modelo.getCuenta() + "-");
                this.modelo.setSigno2(true);
                this.vista.jText1Operacion.setText(this.modelo.getCuenta());
            } else if (this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) != ('-') && this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) != ('+')
                    && this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) != ('*') && this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) != ('/') && this.modelo.isOpeAsignado() == false) {
                this.modelo.setCuenta(this.modelo.getCuenta() + "-");
                this.modelo.setOpeAsignado(true);
                this.vista.jText1Operacion.setText(this.modelo.getCuenta());
            } else {
            }
        }else if (e.getSource().equals(this.vista.jButton16Division)) {
            while (!this.modelo.isOpeAsignado()) {
            if (this.modelo.getCuenta().equals("")) {
                this.vista.jText2Resultado.setText("Primero debe ingresar numeros");
            } else if (this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1)
                    == ('+') || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('*') || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('/')) {
                this.vista.jText2Resultado.setText("Error, dos operadores aritmeticos consecutivos");
            } else {
                this.modelo.setCuenta(this.modelo.getCuenta() + "/");
                this.modelo.setOpeAsignado(true);
            }
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
            break;
        }
        }else if (e.getSource().equals(this.vista.jButton17Producto)) {
                        while (!this.modelo.isOpeAsignado()) {
            if (this.modelo.getCuenta().equals("")) {
                this.vista.jText2Resultado.setText("Primero debe ingresar numeros");
            } else if (this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1)
                    == ('+') || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('*') || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == ('/')) {
                this.vista.jText2Resultado.setText("Error, dos operadores aritmeticos consecutivos");
            } else {
                this.modelo.setCuenta(this.modelo.getCuenta() + "*");
                this.modelo.setOpeAsignado(true);
            }
            this.vista.jText1Operacion.setText(this.modelo.getCuenta());
            break;
        }
        }else if (e.getSource().equals(this.vista.jButton9COMA)) {
            if (this.modelo.getCuenta().equals("") || this.modelo.getCuenta().charAt(this.modelo.getCuenta().length() - 1) == '.') {

        } else {
            this.modelo.setCuenta(this.modelo.getCuenta() + ".");
        }
        }else if (e.getSource().equals(this.vista.jButtonLimpiar)) {
        this.modelo.setCuenta("");
        this.vista.jText1Operacion.setText("");
        this.vista.jText2Resultado.setText("");
        modelo=new Modelo("", "", "", "", false, false, false);
//        nro1 = "";
//        nro2 = "";
//        operador = "";
//        signo1 = false;
//        signo2 = false;
//        opeAsignado = false;
        }

    }

}
