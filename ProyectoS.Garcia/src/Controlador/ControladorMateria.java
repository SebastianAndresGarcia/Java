/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Datos.MateriaDAO;
import Modelo.Materia;
import Vista.JF_Materia;
import javax.swing.table.DefaultTableModel;
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

/**
 *
 * @author hp
 */
public class ControladorMateria implements ActionListener, MouseListener, ItemListener {

    private Modelo.Materia Materia;
    private Vista.JF_Materia JF_Materia;
    private DefaultTableModel modeloTabla;

    public ControladorMateria(Materia Materia, JF_Materia JF_Materia) {
        this.Materia = Materia;
        this.JF_Materia = JF_Materia;
        this.JF_Materia.setVisible(true);
        this.JF_Materia.setLocationRelativeTo(null);
        comboBoxDNIProfe();
        this.llenarTabla(this.JF_Materia.getjTable1());

        this.JF_Materia.getjBNuevamateria().addActionListener(this);
        this.JF_Materia.getjBModificaMateria().addActionListener(this);
        this.JF_Materia.getjBEliminarMateria().addActionListener(this);
        this.JF_Materia.getjTable1().addMouseListener(this);
        this.JF_Materia.getjBSalir().addActionListener(this);
        this.JF_Materia.getjTCodMateria().setEditable(false);
        this.JF_Materia.getjTFnombreProfe().setEditable(false);
        this.JF_Materia.getjCBoxDNIProf().addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.JF_Materia.getjBNuevamateria())) {

            this.Materia.setMat_nombre(this.JF_Materia.getjTMateria().getText());
            if (this.JF_Materia.getjTMateria().getText().equals("") || this.JF_Materia.getjCBoxDNIProf().getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete los campos vacíos");
            } else if (!Materia.validarMateria(this.Materia.getMat_nombre())) {
                this.Materia.setMat_prof_dni(Integer.parseInt((this.JF_Materia.getjCBoxDNIProf().getSelectedItem().toString())));
                this.Materia.agregarMateria(Materia);

                limpiarTabla(this.JF_Materia.getjTable1());
                llenarTabla(this.JF_Materia.getjTable1());
                limpiarJTFIELDS();

            } else {
                JOptionPane.showMessageDialog(null, "La materia ya se encuentra en la lista, ingrese otra materia");
            }

        } else if (e.getSource().equals(this.JF_Materia.getjBModificaMateria())) {
            this.Materia.setMat_nombre(this.JF_Materia.getjTMateria().getText());

            if (this.JF_Materia.getjTMateria().getText().equals("") || this.JF_Materia.getjTCodMateria().getText().equals("") || this.JF_Materia.getjCBoxDNIProf().getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click sobre la materia que desea modificar. \nLuego edite los campos y presione modificar");
            } else { 
                this.Materia.setMat_prof_dni(Integer.parseInt(this.JF_Materia.getjCBoxDNIProf().getSelectedItem().toString()));
                this.Materia.setMat_cod(Integer.parseInt(this.JF_Materia.getjTCodMateria().getText()));
                this.Materia.ModificaMateria(Materia);
                limpiarTabla(this.JF_Materia.getjTable1());
                llenarTabla(this.JF_Materia.getjTable1());
                limpiarJTFIELDS();

            }
        } else if (e.getSource().equals(this.JF_Materia.getjBEliminarMateria())) {
            if (this.JF_Materia.getjTMateria().getText().equals("") || this.JF_Materia.getjCBoxDNIProf().getSelectedItem().toString().equals("")
                    || this.JF_Materia.getjTCodMateria().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click sobre la materia que desea eliminar. Luego presione Eliminar");
            } else if (this.Materia.EliminaMateria(this.JF_Materia.getjTable1()));
            {
                limpiarTabla(this.JF_Materia.getjTable1());
                llenarTabla(this.JF_Materia.getjTable1());
                limpiarJTFIELDS();

            }
        } else if (e.getSource().equals(this.JF_Materia.getjBSalir())) { //volver al menu principal
            Vista.JF_Menu menu = new Vista.JF_Menu();
            ControladorMenu controlMenu = new ControladorMenu(menu);
            menu.setVisible(true);
            this.JF_Materia.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.JF_Materia.getjTable1().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.JF_Materia.getjTCodMateria().setText(String.valueOf(this.JF_Materia.getjTable1().getValueAt(fila, 0)));
                this.JF_Materia.getjTMateria().setText(String.valueOf(this.JF_Materia.getjTable1().getValueAt(fila, 1)));
                this.JF_Materia.getjCBoxDNIProf().setSelectedItem(String.valueOf(this.JF_Materia.getjTable1().getValueAt(fila, 2)));            
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

    private void limpiarTabla(JTable jTable1) {
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    private void llenarTabla(JTable tabla) {
        modeloTabla = new DefaultTableModel(null, Columnas());
        ArrayList<Modelo.Materia> materias;
        materias = this.Materia.ListadoMaterias();
        this.limpiarTabla(this.JF_Materia.getjTable1());
        Object datos[] = new Object[3];
        if (materias.size() > 0) {
            for (int i = 0; i < materias.size(); i++) {
                datos[0] = materias.get(i).getMat_cod();
                datos[1] = materias.get(i).getMat_nombre();
                datos[2] = materias.get(i).getMat_prof_dni();

                modeloTabla.addRow(datos);
            }
        }

        tabla.setModel(modeloTabla);
        materias.clear();
    }

    private void limpiarJTFIELDS() {
        this.JF_Materia.getjTCodMateria().setText("");
        this.JF_Materia.getjCBoxDNIProf().setSelectedIndex(0);
        this.JF_Materia.getjTMateria().setText("");
    }

    private String[] Columnas() {
        String[] Columna = {"Codigo", "Nombre", "Profesor"};
        return Columna;
    }

    private void comboBoxDNIProfe() {
        ArrayList<Modelo.Profesor> dni = this.Materia.DNIProfe();
        Iterator<Modelo.Profesor> dniIterator = dni.iterator();
        this.JF_Materia.getjCBoxDNIProf().addItem("");
        while (dniIterator.hasNext()) {
            this.JF_Materia.getjCBoxDNIProf().addItem(Integer.toString(dniIterator.next().getDni()));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getItemSelectable().equals(this.JF_Materia.getjCBoxDNIProf())) {
            if (this.JF_Materia.getjCBoxDNIProf().getSelectedItem().toString().equals("")) {
                this.JF_Materia.getjTFnombreProfe().setText("");
            } else {
                int eleccion = Integer.parseInt(this.JF_Materia.getjCBoxDNIProf().getSelectedItem().toString());
                ArrayList<Modelo.Profesor> dni = this.Materia.DNIProfe();
                Iterator<Modelo.Profesor> dniIterator = dni.iterator();
                int i = 0;
                while (dniIterator.hasNext()) {

                    if (eleccion == dniIterator.next().getDni()) {
                        break;
                    } else {
                        i++;
                    }
                }

                this.JF_Materia.getjTFnombreProfe().setText(dni.get(i).getNombre() + " " + dni.get(i).getApellido());
            }
        }
    }
}
