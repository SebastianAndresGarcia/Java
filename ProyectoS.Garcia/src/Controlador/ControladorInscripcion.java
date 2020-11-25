/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inscripcion;
import Vista.JF_Inscripcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
class ControladorInscripcion implements ActionListener, MouseListener, ItemListener {

    private Modelo.Inscripcion inscripcion;
    private Vista.JF_Inscripcion vistaInsc;
    private DefaultTableModel modeloTabla;
    private ArrayList<Modelo.Carrera> carreras=new ArrayList();
    public ControladorInscripcion(Inscripcion Inscripcion, JF_Inscripcion vistaInsc) {
        this.inscripcion = Inscripcion;
        this.vistaInsc = vistaInsc;
        this.vistaInsc.setVisible(true);
        this.vistaInsc.setLocationRelativeTo(null);
        comboboxCarreras(carreras);
        llenarTabla(this.vistaInsc.getjTablaInscripciones());
        this.vistaInsc.getjBnueva().addActionListener(this);
        this.vistaInsc.getjBVolver().addActionListener(this);
        this.vistaInsc.getjTablaInscripciones().addMouseListener(this);
        this.vistaInsc.getjBModifica().addActionListener(this);
        this.vistaInsc.getjCBoxCarreras().addItemListener(this);
        this.vistaInsc.getjTextNombreCarrera().setEditable(false);
        this.vistaInsc.getjBEliminar().addActionListener(this);
        this.vistaInsc.getjTextcodigoInsc().setEditable(false);
        this.vistaInsc.getjTextFechaInsc().setText("dd-mm-aaaa");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(this.vistaInsc.getjBnueva())) {

            this.inscripcion.setInsc_fecha(this.vistaInsc.getjTextFechaInsc().getText());
            this.inscripcion.setInsc_nombre(this.vistaInsc.getjTextnomInsc().getText());

            if (this.vistaInsc.getjTextnomInsc().getText().equals("") || 
                    this.vistaInsc.getjCBoxCarreras().getSelectedItem().toString().equals("") || this.vistaInsc.getjTextFechaInsc().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            } else if (inscripcion.validarFechaNac(this.inscripcion.getInsc_fecha())) {
                this.inscripcion.setInsc_car_cod(Integer.parseInt(this.vistaInsc.getjCBoxCarreras().getSelectedItem().toString()));
                this.inscripcion.setInsc_fecha(inscripcion.fechaSQL(this.vistaInsc.getjTextFechaInsc().getText()));
                if (inscripcion.AgregaInscripcion(inscripcion)) {
                    limpiarTabla(this.vistaInsc.getjTablaInscripciones());
                    llenarTabla(this.vistaInsc.getjTablaInscripciones());
                    limpiarJTFIELDS();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha con formato dd-mm-aaaa");
            }

        } else if (ae.getSource().equals(this.vistaInsc.getjBVolver())) {
            Vista.JF_Menu menu = new Vista.JF_Menu();
            ControladorMenu controlMenu = new ControladorMenu(menu);
            menu.setVisible(true);
            this.vistaInsc.dispose();
        } else if (ae.getSource().equals(this.vistaInsc.getjBModifica())) {

            this.inscripcion.setInsc_fecha(this.vistaInsc.getjTextFechaInsc().getText());
            this.inscripcion.setInsc_nombre(this.vistaInsc.getjTextnomInsc().getText());

            if (this.vistaInsc.getjTextnomInsc().getText().equals("") || this.vistaInsc.getjTextcodigoInsc().getText().equals("")
                    || this.vistaInsc.getjCBoxCarreras().getSelectedItem().toString().equals("") || this.vistaInsc.getjTextFechaInsc().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una inscripcion haciendo click en la lista. Luego modifique sus campos");
            } else if (inscripcion.validarFechaNac(this.inscripcion.getInsc_fecha())) {
                this.inscripcion.setInsc_cod(Integer.parseInt(this.vistaInsc.getjTextcodigoInsc().getText()));
                this.inscripcion.setInsc_fecha(inscripcion.fechaSQL(this.vistaInsc.getjTextFechaInsc().getText()));
                this.inscripcion.setInsc_car_cod(Integer.parseInt(this.vistaInsc.getjCBoxCarreras().getSelectedItem().toString()));
                if (inscripcion.ModificaInscripcion(inscripcion)) {
                    limpiarTabla(this.vistaInsc.getjTablaInscripciones());
                    llenarTabla(this.vistaInsc.getjTablaInscripciones());
                    limpiarJTFIELDS();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha con formato dd-mm-aaaa");
            }

        } else if (ae.getSource().equals(this.vistaInsc.getjBEliminar())) {
            if (this.vistaInsc.getjTextnomInsc().getText().equals("") || this.vistaInsc.getjTextcodigoInsc().getText().equals("")
                    ||this.vistaInsc.getjCBoxCarreras().getSelectedItem().toString().equals("") || this.vistaInsc.getjTextFechaInsc().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Seleccione una inscripcion haciendo click en la lista. Luego presione eliminar");
            } else if (this.inscripcion.eliminarInsc(this.vistaInsc.getjTablaInscripciones())) {

                limpiarTabla(this.vistaInsc.getjTablaInscripciones());
                llenarTabla(this.vistaInsc.getjTablaInscripciones());
                limpiarJTFIELDS();

            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.vistaInsc.getjTablaInscripciones().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.vistaInsc.getjTextcodigoInsc().setText(String.valueOf(this.vistaInsc.getjTablaInscripciones().getValueAt(fila, 0)));
                this.vistaInsc.getjTextnomInsc().setText(String.valueOf(this.vistaInsc.getjTablaInscripciones().getValueAt(fila, 1)));
                this.vistaInsc.getjTextFechaInsc().setText(String.valueOf(this.vistaInsc.getjTablaInscripciones().getValueAt(fila, 2)));
                this.vistaInsc.getjCBoxCarreras().setSelectedItem(String.valueOf(this.vistaInsc.getjTablaInscripciones().getValueAt(fila, 3)));
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
        ArrayList<Modelo.Inscripcion> ins;
        ins = this.inscripcion.ListadoInscripciones();
        this.limpiarTabla(this.vistaInsc.getjTablaInscripciones());
        Object datos[] = new Object[4];
        if (ins.size() > 0) {
            for (int i = 0; i < ins.size(); i++) {
                datos[0] = ins.get(i).getInsc_cod();
                datos[1] = ins.get(i).getInsc_nombre();
                datos[2] = this.inscripcion.formatoFecha(ins.get(i).getInsc_fecha());
                datos[3] = ins.get(i).getInsc_car_cod();

                modeloTabla.addRow(datos);
            }
        }

        tabla.setModel(modeloTabla);
        ins.clear();
    }

    private String[] Columnas() {
        String[] Columna = {"Cod Inscripcion", "Nombre", "Fecha", "Cod Carrera"};
        return Columna;
    }

    private void limpiarTabla(JTable jTablaInscripciones) {
        DefaultTableModel tb = (DefaultTableModel) jTablaInscripciones.getModel();
        int a = jTablaInscripciones.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    private void limpiarJTFIELDS() {
        this.vistaInsc.getjTextnomInsc().setText("");
        this.vistaInsc.getjTextcodigoInsc().setText("");
        this.vistaInsc.getjTextFechaInsc().setText("dd-mm-aaaa");
        this.vistaInsc.getjCBoxCarreras().setSelectedIndex(0);
    }

    private void comboboxCarreras(ArrayList<Modelo.Carrera> carreras) {
        carreras = this.inscripcion.ListadoCarreras();
        Iterator<Modelo.Carrera> carrerasIterator = carreras.iterator();
        this.vistaInsc.getjCBoxCarreras().addItem("");
        while (carrerasIterator.hasNext()) {
            this.vistaInsc.getjCBoxCarreras().addItem(Integer.toString(carrerasIterator.next().getCar_cod()));
        }
    }
      @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getItemSelectable().equals(this.vistaInsc.getjCBoxCarreras())) {
            if (this.vistaInsc.getjCBoxCarreras().getSelectedItem().toString().equals("")) {
                this.vistaInsc.getjTextNombreCarrera().setText("");
            } else {
                int eleccion = Integer.parseInt(this.vistaInsc.getjCBoxCarreras().getSelectedItem().toString());
                carreras = this.inscripcion.ListadoCarreras();
                 Iterator<Modelo.Carrera> carrerasIterator = carreras.iterator();
                int i = 0;
                while (carrerasIterator.hasNext()) {

                    if (eleccion == carrerasIterator.next().getCar_cod()) {
                        break;
                    } else {
                        i++;
                    }
                }

                this.vistaInsc.getjTextNombreCarrera().setText(carreras.get(i).getCar_nombre());
            }
        }
    }
}
