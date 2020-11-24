/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cursado;
import Vista.JF_Cursado;
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
public class ControladorCursado implements ActionListener, MouseListener, ItemListener {

    private Modelo.Cursado cursado;
    private Vista.JF_Cursado cursadoVista;
    private DefaultTableModel modeloTabla;

    public ControladorCursado(Cursado cursado, JF_Cursado cursadoVista) {
        this.cursado = cursado;
        this.cursadoVista = cursadoVista;
        this.cursadoVista.setVisible(true);
        this.cursadoVista.setLocationRelativeTo(null);
        comboBoxAlumno();
        comboBoxMateria();
        this.llenarTabla(this.cursadoVista.getjTableCursado());
        this.cursadoVista.getjBAgregaNota().addActionListener(this);
        this.cursadoVista.getjBmodNota().addActionListener(this);
        this.cursadoVista.getjBSalir().addActionListener(this);
        this.cursadoVista.getjTableCursado().addMouseListener(this);
        this.cursadoVista.getjBEliminar().addActionListener(this);
        this.cursadoVista.getjCBoxDNIAlum().addItemListener(this);
        this.cursadoVista.getjCBoxMateria().addItemListener(this);
        this.cursadoVista.getjTextMatnombre().setEditable(false);
        this.cursadoVista.getjTextFNombreAlu().setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(this.cursadoVista.getjBAgregaNota())) {

            if (this.cursadoVista.getjTextNotas().getText().equals("") || this.cursadoVista.getjTextMatnombre().getText().equals("")
                    || this.cursadoVista.getjCBoxDNIAlum().getSelectedItem().toString().equals("") || this.cursadoVista.getjCBoxMateria().getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete los campos vacíos");
            } else {
                this.cursado.setCur_alu_dni(Integer.parseInt((this.cursadoVista.getjCBoxDNIAlum().getSelectedItem().toString())));
                this.cursado.setCur_mat_cod(Integer.parseInt((this.cursadoVista.getjCBoxMateria().getSelectedItem().toString())));
                this.cursado.setCur_nota(Integer.parseInt(this.cursadoVista.getjTextNotas().getText()));
                if (!cursado.validarMateria(cursado)) {
                    this.cursado.agregarNota(cursado);
                    this.limpiarTabla(this.cursadoVista.getjTableCursado());
                    this.llenarTabla(this.cursadoVista.getjTableCursado());
                    this.limpiarJTFIELDS();
                } else {
                    JOptionPane.showMessageDialog(null, "La nota que quiere crear ya existe, si desea puede modificarla");
                }
            }

        } else if (ae.getSource().equals(this.cursadoVista.getjBmodNota())) { //MODIFICAR NOTA

            if (this.cursadoVista.getjTextNotas().getText().equals("") || this.cursadoVista.getjTextMatnombre().getText().equals("")
                    || this.cursadoVista.getjCBoxDNIAlum().getSelectedItem().toString().equals("") || this.cursadoVista.getjCBoxMateria().getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete los campos vacíos o haga click en una materia para completarlos automáticamente y luego modifique");
            } else {
                this.cursado.setCur_alu_dni(Integer.parseInt((this.cursadoVista.getjCBoxDNIAlum().getSelectedItem().toString())));
                this.cursado.setCur_mat_cod(Integer.parseInt((this.cursadoVista.getjCBoxMateria().getSelectedItem().toString())));
                this.cursado.setCur_nota(Integer.parseInt(this.cursadoVista.getjTextNotas().getText()));

                if (this.cursado.validarMateria(cursado)) {
                    this.cursado.modificaNota(cursado);
                    this.limpiarTabla(this.cursadoVista.getjTableCursado());
                    this.llenarTabla(this.cursadoVista.getjTableCursado());
                    this.limpiarJTFIELDS();
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede modificar, la nota no existe en la base de datos."
                            + "\nSi desea agregar la nota, presione nueva.");
                }
            }
        } else if (ae.getSource().equals(this.cursadoVista.getjBSalir())) {
            Vista.JF_Menu menu = new Vista.JF_Menu();
            ControladorMenu controlMenu = new ControladorMenu(menu);
            menu.setVisible(true);
            this.cursadoVista.dispose();
        } else if (ae.getSource().equals(this.cursadoVista.getjBEliminar())) {
            if (this.cursadoVista.getjTextNotas().getText().equals("") || this.cursadoVista.getjTextMatnombre().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click sobre el elemento de la tabla que desea eliminar. Luego presione eliminar");
            } else if (this.cursado.EliminarNota(this.cursadoVista.getjTableCursado()));
            limpiarTabla(this.cursadoVista.getjTableCursado());
            llenarTabla(this.cursadoVista.getjTableCursado());
            limpiarJTFIELDS();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getButton() == 1) {
            int fila = this.cursadoVista.getjTableCursado().rowAtPoint(me.getPoint());
            if (fila > -1) {
                this.cursadoVista.getjCBoxDNIAlum().setSelectedItem(String.valueOf(this.cursadoVista.getjTableCursado().getValueAt(fila, 0)));
                this.cursadoVista.getjCBoxMateria().setSelectedItem(String.valueOf(this.cursadoVista.getjTableCursado().getValueAt(fila, 1)));
                this.cursadoVista.getjTextNotas().setText(String.valueOf(this.cursadoVista.getjTableCursado().getValueAt(fila, 2)));
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

    private void comboBoxAlumno() {
        ArrayList<Modelo.Alumno> dni = this.cursado.DNIAlumno();
        Iterator<Modelo.Alumno> dniIterator = dni.iterator();
        this.cursadoVista.getjCBoxDNIAlum().addItem("");
        while (dniIterator.hasNext()) {
            this.cursadoVista.getjCBoxDNIAlum().addItem(Integer.toString(dniIterator.next().getDni()));
        }
    }

    private void comboBoxMateria() {
        ArrayList<Modelo.Materia> materia = this.cursado.DatosMateria();
        Iterator<Modelo.Materia> materiaIterator = materia.iterator();
        this.cursadoVista.getjCBoxMateria().addItem("");
        while (materiaIterator.hasNext()) {
            this.cursadoVista.getjCBoxMateria().addItem(Integer.toString(materiaIterator.next().getMat_cod()));
        }
    }

    private void llenarTabla(JTable tabla) {
        modeloTabla = new DefaultTableModel(null, Columnas());
        ArrayList<Modelo.Cursado> cursados;
        cursados = this.cursado.DatoCursado();
        this.limpiarTabla(this.cursadoVista.getjTableCursado());
        Object datos[] = new Object[3];
        if (cursados.size() > 0) {
            for (int i = 0; i < cursados.size(); i++) {
                datos[0] = cursados.get(i).getCur_alu_dni();
                datos[1] = cursados.get(i).getCur_mat_cod();
                datos[2] = cursados.get(i).getCur_nota();
                modeloTabla.addRow(datos);
            }
        }
        tabla.setModel(modeloTabla);
        cursados.clear();
    }

    private String[] Columnas() {
        String[] Columna = {"Alumno", "Materia", "Nota"};
        return Columna;
    }

    private void limpiarTabla(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    private void limpiarJTFIELDS() {
        this.cursadoVista.getjCBoxDNIAlum().setSelectedIndex(0);
        this.cursadoVista.getjCBoxMateria().setSelectedIndex(0);
        this.cursadoVista.getjTextNotas().setText("");
        this.cursadoVista.getjTextMatnombre().setText("");
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getItemSelectable().equals(this.cursadoVista.getjCBoxDNIAlum()) || ie.getItemSelectable().equals(this.cursadoVista.getjCBoxMateria())) {
            if (this.cursadoVista.getjCBoxDNIAlum().getSelectedItem().toString().equals("")) {
                this.cursadoVista.getjTextFNombreAlu().setText("");
            } else {
                int eleccion = Integer.parseInt(this.cursadoVista.getjCBoxDNIAlum().getSelectedItem().toString());
                ArrayList<Modelo.Alumno> dni = this.cursado.DNIAlumno();
                Iterator<Modelo.Alumno> dniIterator = dni.iterator();
                int i = 0;
                while (dniIterator.hasNext()) {
                    if (eleccion == dniIterator.next().getDni()) {
                        break;
                    } else {
                        i++;
                    }
                }
                this.cursadoVista.getjTextFNombreAlu().setText(dni.get(i).getNombre() + " " + dni.get(i).getApellido());
            }

            if (this.cursadoVista.getjCBoxMateria().getSelectedItem().toString().equals("")) {
                this.cursadoVista.getjTextMatnombre().setText("");
            } else {
                int eleccion = Integer.parseInt(this.cursadoVista.getjCBoxMateria().getSelectedItem().toString());
                ArrayList<Modelo.Materia> mat = this.cursado.DatosMateria();
                Iterator<Modelo.Materia> matIterator = mat.iterator();
                int i = 0;
                while (matIterator.hasNext()) {

                    if (eleccion == matIterator.next().getMat_cod()) {
                        this.cursadoVista.getjTextMatnombre().setText(mat.get(i).getMat_nombre());

                        break;
                    } else {
                        i++;
                    }
                }
                this.cursadoVista.getjTextMatnombre().setText(mat.get(i).getMat_nombre());
            }
        }
    }
}
