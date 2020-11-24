/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Profesor;
import Vista.JF_Profesor;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author hp
 */
public class ControladorProfesor implements ActionListener, MouseListener {

    private Modelo.Profesor profesor;
    private Vista.JF_Profesor profesorVista;
    private DefaultTableModel modeloTabla;

    public ControladorProfesor(Profesor profesor, JF_Profesor profesorVista) {
        this.profesor = profesor;
        this.profesorVista = profesorVista;
        this.profesorVista.setVisible(true);
        this.profesorVista.setLocationRelativeTo(null);
        this.llenarTabla(this.profesorVista.getjTableProfesor());
        this.profesorVista.getjB1_profNuevo().addActionListener(this);
        this.profesorVista.getjB3_profmodificar().addActionListener(this);
        this.profesorVista.getjB2_profeliminar().addActionListener(this);
        this.profesorVista.getjBprof_Salir().addActionListener(this);
        this.profesorVista.getjTableProfesor().addMouseListener(this);
        this.profesorVista.getjBLimpiar().addActionListener(this);
        this.profesorVista.getJTextFechaNac().setText("dd-mm-aaaa");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.profesorVista.getjB1_profNuevo())) {
            this.profesor.setNombre(this.profesorVista.getjT3_profNombre().getText());
            this.profesor.setApellido(this.profesorVista.getjT1_profApellido().getText());
            this.profesor.setTelefono(this.profesorVista.getjT5_profTelefono().getText());
            this.profesor.setDomicilio(this.profesorVista.getjT4_profDlio().getText());
            this.profesor.setFecha_nac(profesor.fechaSQL(this.profesorVista.getJTextFechaNac().getText()));
            if (this.profesorVista.getjT2_profDNI().getText().equals("") || this.profesorVista.getjT3_profNombre().getText().equals("")
                    || this.profesorVista.getjT1_profApellido().getText().equals("") || this.profesorVista.getjT4_profDlio().getText().equals("")
                    || this.profesorVista.getjT5_profTelefono().getText().equals("") || this.profesorVista.getJTextFechaNac().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete los campos vacíos");
            } else if (!this.profesor.revisarDNI(Integer.parseInt(this.profesorVista.getjT2_profDNI().getText()))) {
                if (profesor.validarFechaNac(profesor.formatoFecha(this.profesor.getFecha_nac()))) {
                    this.profesor.setDni(Integer.parseInt(this.profesorVista.getjT2_profDNI().getText()));
                    this.profesor.registrarProfesor(profesor);
                    limpiarTabla(this.profesorVista.getjTableProfesor());
                    llenarTabla(this.profesorVista.getjTableProfesor());
                    limpiarJTFIELDS();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una fecha con formato dd-mm-aaaa");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El DNI ya se encuentra agregado a la lista. Intente nuevamente con otro dni");
            }

        } else if (e.getSource().equals(this.profesorVista.getjB3_profmodificar())) {
            this.profesor.setNombre(this.profesorVista.getjT3_profNombre().getText());
            this.profesor.setApellido(this.profesorVista.getjT1_profApellido().getText());
            this.profesor.setTelefono(this.profesorVista.getjT5_profTelefono().getText());
            this.profesor.setDomicilio(this.profesorVista.getjT4_profDlio().getText());
            this.profesor.setFecha_nac(profesor.fechaSQL(this.profesorVista.getJTextFechaNac().getText()));

            if (this.profesorVista.getjT2_profDNI().getText().equals("") || this.profesorVista.getjT3_profNombre().getText().equals("")
                    || this.profesorVista.getjT1_profApellido().getText().equals("") || this.profesorVista.getjT4_profDlio().getText().equals("")
                    || this.profesorVista.getjT5_profTelefono().getText().equals("") || this.profesorVista.getJTextFechaNac().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Primero haga click sobre el profesor que desea modificar");
            } else if (profesor.validarFechaNac(profesor.formatoFecha(this.profesor.getFecha_nac()))) {
                this.profesor.setDni(Integer.parseInt(this.profesorVista.getjT2_profDNI().getText()));
                if(this.profesor.revisarDNI(Integer.parseInt(this.profesorVista.getjT2_profDNI().getText()))){
                this.profesor.modificarProfesor(profesor);
                limpiarTabla(this.profesorVista.getjTableProfesor());
                llenarTabla(this.profesorVista.getjTableProfesor());
                limpiarJTFIELDS();
                this.profesorVista.getjT2_profDNI().setEditable(true);}else JOptionPane.showMessageDialog(null, "El DNI no existe en la base de datos. Ingrese un DNI existente en la tabla, \no haga click sobre un alumno de la tabla");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha con formato dd-mm-aaaa");
            }

        } else if (e.getSource().equals(this.profesorVista.getjB2_profeliminar())) {
            if (this.profesorVista.getjT2_profDNI().getText().equals("") || this.profesorVista.getjT3_profNombre().getText().equals("")
                    || this.profesorVista.getjT1_profApellido().getText().equals("") || this.profesorVista.getjT4_profDlio().getText().equals("")
                    || this.profesorVista.getjT5_profTelefono().getText().equals("") || this.profesorVista.getJTextFechaNac().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click sobre la persona, luego presione eliminar");
            } else if (this.profesor.eliminarProf(this.profesorVista.getjTableProfesor())) {
                limpiarTabla(this.profesorVista.getjTableProfesor());
                llenarTabla(this.profesorVista.getjTableProfesor());
                limpiarJTFIELDS();
                this.profesorVista.getjT2_profDNI().setEditable(true);
            }
        } else if (e.getSource().equals(this.profesorVista.getjBprof_Salir())) { //volver al menu principal
            Vista.JF_Menu menu = new Vista.JF_Menu();
            ControladorMenu controlMenu = new ControladorMenu(menu);
            menu.setVisible(true);
            this.profesorVista.dispose();
        } else if (e.getSource().equals(this.profesorVista.getjBLimpiar())) {
            limpiarJTFIELDS();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {
        if (e.getButton() == 1) {
            int fila = this.profesorVista.getjTableProfesor().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.profesorVista.getjT2_profDNI().setText(String.valueOf(this.profesorVista.getjTableProfesor().getValueAt(fila, 0)));
                this.profesorVista.getjT2_profDNI().setEditable(false);
                this.profesorVista.getjT3_profNombre().setText(String.valueOf(this.profesorVista.getjTableProfesor().getValueAt(fila, 1)));
                this.profesorVista.getjT1_profApellido().setText(String.valueOf(this.profesorVista.getjTableProfesor().getValueAt(fila, 2)));
                this.profesorVista.getJTextFechaNac().setText(String.valueOf(this.profesorVista.getjTableProfesor().getValueAt(fila, 3)));
                this.profesorVista.getjT4_profDlio().setText(String.valueOf(this.profesorVista.getjTableProfesor().getValueAt(fila, 4)));
                this.profesorVista.getjT5_profTelefono().setText(String.valueOf(this.profesorVista.getjTableProfesor().getValueAt(fila, 5)));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {

    }

    @Override
    public void mouseExited(MouseEvent me
    ) {

    }

    public void llenarTabla(JTable tabla) {
        modeloTabla = new DefaultTableModel(null, Columnas());
        ArrayList<Modelo.Profesor> profesores;
        profesores = this.profesor.verProfesoresTodos();
        this.limpiarTabla(this.profesorVista.getjTableProfesor());
        Object datos[] = new Object[6];
        if (profesores.size() > 0) {
            for (int i = 0; i < profesores.size(); i++) {
                datos[0] = profesores.get(i).getDni();
                datos[1] = profesores.get(i).getNombre();
                datos[2] = profesores.get(i).getApellido();
                datos[3] = profesor.formatoFecha(profesores.get(i).getFecha_nac());
                datos[4] = profesores.get(i).getDomicilio();
                datos[5] = profesores.get(i).getTelefono();
                modeloTabla.addRow(datos);
            }
        }
        tabla.setModel(modeloTabla);
        profesores.clear();
    }

    public String[] Columnas() {
        String[] Columna = {"DNI", "Nombre", "Apellido", "Fecha Nacimiento", "Domicilio", "Telefono"};
        return Columna;
    }

    private void limpiarTabla(JTable jTable1) {
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int a = jTable1.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    private void limpiarJTFIELDS() {
        this.profesorVista.getjT3_profNombre().setText("");
        this.profesorVista.getjT1_profApellido().setText("");
        this.profesorVista.getjT2_profDNI().setText("");
        this.profesorVista.getjT4_profDlio().setText("");
        this.profesorVista.getjT5_profTelefono().setText("");
        this.profesorVista.getJTextFechaNac().setText("dd-mm-aaaa");
    }
}
