/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Carrera;
import Vista.JF_Carrera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
class ControladorCarrera implements ActionListener, MouseListener {

    private Modelo.Carrera carrera;
    private Vista.JF_Carrera vistaCarrera;
    private DefaultTableModel modeloTabla;

    ControladorCarrera(Carrera carrera, JF_Carrera vistaCarrera) {
        this.carrera = carrera;
        this.vistaCarrera = vistaCarrera;
        this.vistaCarrera.setVisible(true);
        this.vistaCarrera.setLocationRelativeTo(null);
        llenarTabla(this.vistaCarrera.getjTableCarreras());
        this.vistaCarrera.getjBNuevaCarrera().addActionListener(this);
        this.vistaCarrera.getjBModificar().addActionListener(this);
        this.vistaCarrera.getjBEliminar().addActionListener(this);
        this.vistaCarrera.getjBSalir().addActionListener(this);
        this.vistaCarrera.getjTableCarreras().addMouseListener(this);
        this.vistaCarrera.getjTextCodCarrera().setEditable(false);

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource().equals(this.vistaCarrera.getjBNuevaCarrera())) {
            this.carrera.setCar_nombre(this.vistaCarrera.getjTextNombreCarr().getText());

            if (this.vistaCarrera.getjTextNombreCarr().getText().equals("") || this.vistaCarrera.getjTextDuracion().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete los campos vacíos");
            } else {
                this.carrera.setCar_duracion(Integer.parseInt(this.vistaCarrera.getjTextDuracion().getText()));
                this.carrera.AgregarCarrera(carrera);
                limpiarTabla(this.vistaCarrera.getjTableCarreras());
                llenarTabla(this.vistaCarrera.getjTableCarreras());
                limpiarJTextFields();
            }
        } else if (a.getSource().equals(this.vistaCarrera.getjBModificar())) {

            this.carrera.setCar_nombre(this.vistaCarrera.getjTextNombreCarr().getText());
            if (this.vistaCarrera.getjTextNombreCarr().getText().equals("") || this.vistaCarrera.getjTextDuracion().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click en la carrera que desea modificar. \nLuego edite los campos y presione modificar");
            } else {
                this.carrera.setCar_duracion(Integer.parseInt(this.vistaCarrera.getjTextDuracion().getText()));
                this.carrera.setCar_cod(Integer.parseInt(this.vistaCarrera.getjTextCodCarrera().getText()));
                if (this.carrera.ModificaCarrera(carrera)) {
                    limpiarTabla(this.vistaCarrera.getjTableCarreras());
                    llenarTabla(this.vistaCarrera.getjTableCarreras());
                    limpiarJTextFields();
                } else System.out.println("no modifica");
            }
        } else if (a.getSource().equals(this.vistaCarrera.getjBEliminar())) {
            if (this.vistaCarrera.getjTextNombreCarr().getText().equals("") || this.vistaCarrera.getjTextDuracion().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click en la carrera que desea eliminar. \nLuego presione Eliminar");
            } else if (this.carrera.EliminaCarrera(this.vistaCarrera.getjTableCarreras())) {
                limpiarTabla(this.vistaCarrera.getjTableCarreras());
                llenarTabla(this.vistaCarrera.getjTableCarreras());
                limpiarJTextFields();
            }
        } else if (a.getSource().equals(this.vistaCarrera.getjBSalir())) {
            Vista.JF_Menu menu = new Vista.JF_Menu();
            Controlador.ControladorMenu controlMenu = new ControladorMenu(menu);
            menu.setVisible(true);
            this.vistaCarrera.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.vistaCarrera.getjTableCarreras().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.vistaCarrera.getjTextCodCarrera().setText(String.valueOf(this.vistaCarrera.getjTableCarreras().getValueAt(fila, 0)));
                this.vistaCarrera.getjTextNombreCarr().setText(String.valueOf(this.vistaCarrera.getjTableCarreras().getValueAt(fila, 1)));
                this.vistaCarrera.getjTextDuracion().setText(String.valueOf(this.vistaCarrera.getjTableCarreras().getValueAt(fila, 2)));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    private void llenarTabla(JTable tabla) {
        modeloTabla = new DefaultTableModel(null, Columnas());
        ArrayList<Modelo.Carrera> car;
        car = this.carrera.ListadoCarreras();
        this.limpiarTabla(this.vistaCarrera.getjTableCarreras());
        Object datos[] = new Object[3];
        if (car.size() > 0) {
            for (int i = 0; i < car.size(); i++) {
                datos[0] = car.get(i).getCar_cod();
                datos[1] = car.get(i).getCar_nombre();
                datos[2] = car.get(i).getCar_duracion();

                modeloTabla.addRow(datos);
            }
        }

        tabla.setModel(modeloTabla);
        car.clear();
    }

    private void limpiarTabla(JTable jTableCarreras) {
        DefaultTableModel tb = (DefaultTableModel) jTableCarreras.getModel();
        int a = jTableCarreras.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    private void limpiarJTextFields() {
        this.vistaCarrera.getjTextNombreCarr().setText("");
        this.vistaCarrera.getjTextDuracion().setText("");
    }

    private String[] Columnas() {
        String[] Columna = {"Codigo", "Carrera", "Cursado en años"};
        return Columna;
    }

}
