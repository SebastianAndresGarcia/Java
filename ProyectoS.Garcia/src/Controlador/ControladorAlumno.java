/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.JF_Alumnos;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ControladorAlumno implements ActionListener, MouseListener {

    private Modelo.Alumno alumno;
    private JF_Alumnos AlumnoVista;
    private DefaultTableModel modeloTabla;

    public ControladorAlumno(Modelo.Alumno alumno, JF_Alumnos Vista) {
        this.alumno = alumno;
        this.AlumnoVista = Vista;
        this.AlumnoVista.setVisible(true);
        this.AlumnoVista.setLocationRelativeTo(null);
        this.llenarTabla(this.AlumnoVista.getjTable1());
        this.AlumnoVista.getjB_nuevo().addActionListener(this);
        this.AlumnoVista.getjB_modificar().addActionListener(this);
        this.AlumnoVista.getjB_eliminar().addActionListener(this);
        this.AlumnoVista.getjB_Salir().addActionListener(this);
        this.AlumnoVista.getjTable1().addMouseListener(this);
        this.AlumnoVista.getjTextFechaNac().addActionListener(this);
        this.AlumnoVista.getjB_Limpiar().addActionListener(this);
        this.AlumnoVista.getjTextFechaNac().setText("dd-mm-aaaa");
        this.AlumnoVista.getjTF2DNI().setEditable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.AlumnoVista.getjB_nuevo())) {
            this.alumno.setNombre(this.AlumnoVista.getjTF3Nombre().getText());
            this.alumno.setApellido(this.AlumnoVista.getjTF1Apellido().getText());
            this.alumno.setTelefono(this.AlumnoVista.getjTF5Telefono().getText());
            this.alumno.setDomicilio(this.AlumnoVista.getjTF4dlio().getText());
            this.alumno.setFecha_nac(alumno.fechaSQL(this.AlumnoVista.getjTextFechaNac().getText()));
            if (this.AlumnoVista.getjTF3Nombre().getText().equals("") || this.AlumnoVista.getjTF1Apellido().getText().equals("")
                    || this.AlumnoVista.getjTF2DNI().getText().equals("") || this.AlumnoVista.getjTF5Telefono().getText().equals("")
                    || this.AlumnoVista.getjTF4dlio().getText().equals("") || this.AlumnoVista.getjTextFechaNac().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete los campos vacíos");
            } 
            else if (!this.alumno.revisarDNI(Integer.parseInt(this.AlumnoVista.getjTF2DNI().getText()))) {
                if (alumno.validarFechaNac(alumno.formatoFecha(this.alumno.getFecha_nac()))) {
                    this.alumno.setDni(Integer.parseInt(this.AlumnoVista.getjTF2DNI().getText()));
                    this.alumno.registrarAlumno(alumno);
                    limpiarTabla(this.AlumnoVista.getjTable1());
                    llenarTabla(this.AlumnoVista.getjTable1());
                    limpiarJTFIELDS();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese una fecha con formato dd-mm-aaaa");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El DNI ya se encuentra agregado a la lista. Intente nuevamente con otro dni");
            }

        } else if (e.getSource().equals(this.AlumnoVista.getjB_modificar())) {
            this.alumno.setNombre(this.AlumnoVista.getjTF3Nombre().getText());
            this.alumno.setApellido(this.AlumnoVista.getjTF1Apellido().getText());
            this.alumno.setTelefono(this.AlumnoVista.getjTF5Telefono().getText());
            this.alumno.setDomicilio(this.AlumnoVista.getjTF4dlio().getText());
            this.alumno.setFecha_nac(alumno.fechaSQL(this.AlumnoVista.getjTextFechaNac().getText()));
            if (this.AlumnoVista.getjTF3Nombre().getText().equals("") || this.AlumnoVista.getjTF1Apellido().getText().equals("")
                    || this.AlumnoVista.getjTF2DNI().getText().equals("") || this.AlumnoVista.getjTF5Telefono().getText().equals("")
                    || this.AlumnoVista.getjTF4dlio().getText().equals("") || this.AlumnoVista.getjTextFechaNac().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click en la tabla sobre el alumno que desea modificar o complete todos los campos");
            } else if (alumno.validarFechaNac(alumno.formatoFecha(this.alumno.getFecha_nac()))) {
                this.alumno.setDni(Integer.parseInt(this.AlumnoVista.getjTF2DNI().getText()));
                if (this.alumno.revisarDNI(Integer.parseInt(this.AlumnoVista.getjTF2DNI().getText()))) {
                    this.alumno.modificarAlumno(alumno);
                   
                    limpiarTabla(this.AlumnoVista.getjTable1());
                    llenarTabla(this.AlumnoVista.getjTable1());
                    limpiarJTFIELDS();
                    this.AlumnoVista.getjTF2DNI().setEditable(true);
                } else JOptionPane.showMessageDialog(null, "El DNI no existe en la base de datos. Ingrese un DNI existente en la tabla, \no haga click sobre un alumno de la tabla");

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha con formato dd-mm-aaaa");
            }
            this.AlumnoVista.getjTF2DNI().setEditable(true);
        } else if (e.getSource().equals(this.AlumnoVista.getjB_eliminar())) {
            if (this.AlumnoVista.getjTF3Nombre().getText().equals("") || this.AlumnoVista.getjTF1Apellido().getText().equals("")
                    || this.AlumnoVista.getjTF2DNI().getText().equals("") || this.AlumnoVista.getjTF5Telefono().getText().equals("")
                    || this.AlumnoVista.getjTF4dlio().getText().equals("") || this.AlumnoVista.getjTextFechaNac().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Haga click sobre el alumno en la tabla, luego presione eliminar");
            } else if (this.alumno.eliminarAlumno(this.AlumnoVista.getjTable1())) {
                limpiarTabla(this.AlumnoVista.getjTable1());
                llenarTabla(this.AlumnoVista.getjTable1());
                limpiarJTFIELDS();
                this.AlumnoVista.getjTF2DNI().setEditable(true);
            }
        } else if (e.getSource().equals(this.AlumnoVista.getjB_Salir())) { //volver al menu principal
            Vista.JF_Menu menu = new Vista.JF_Menu();
            ControladorMenu controlMenu = new ControladorMenu(menu);
            menu.setVisible(true);
            this.AlumnoVista.dispose();
        } else if (e.getSource().equals(this.AlumnoVista.getjB_Limpiar())) {
            limpiarJTFIELDS();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.AlumnoVista.getjTable1().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.AlumnoVista.getjTF2DNI().setText(String.valueOf(this.AlumnoVista.getjTable1().getValueAt(fila, 0)));
                this.AlumnoVista.getjTF2DNI().setEditable(false);
                this.AlumnoVista.getjTF3Nombre().setText(String.valueOf(this.AlumnoVista.getjTable1().getValueAt(fila, 1)));
                this.AlumnoVista.getjTF1Apellido().setText(String.valueOf(this.AlumnoVista.getjTable1().getValueAt(fila, 2)));
                this.AlumnoVista.getjTextFechaNac().setText(String.valueOf(this.AlumnoVista.getjTable1().getValueAt(fila, 3)));
                this.AlumnoVista.getjTF4dlio().setText(String.valueOf(this.AlumnoVista.getjTable1().getValueAt(fila, 4)));
                this.AlumnoVista.getjTF5Telefono().setText(String.valueOf(this.AlumnoVista.getjTable1().getValueAt(fila, 5)));

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

    public void llenarTabla(JTable tabla) {
        modeloTabla = new DefaultTableModel(null, Columnas());
        ArrayList<Modelo.Alumno> alumnos;
        alumnos = this.alumno.verAlumnosTodos();
        this.limpiarTabla(this.AlumnoVista.getjTable1());
        Object datos[] = new Object[7];
        if (alumnos.size() > 0) {
            for (int i = 0; i < alumnos.size(); i++) {
                datos[0] = alumnos.get(i).getDni();
                datos[1] = alumnos.get(i).getNombre();
                datos[2] = alumnos.get(i).getApellido();
                datos[3] = alumno.formatoFecha(alumnos.get(i).getFecha_nac());
                datos[4] = alumnos.get(i).getDomicilio();
                datos[5] = alumnos.get(i).getTelefono();
                datos[6] = alumnos.get(i).getInsc_cod();
                modeloTabla.addRow(datos);
            }
        }

        tabla.setModel(modeloTabla);
        alumnos.clear();
    }

    public String[] Columnas() {
        String[] Columna = {"DNI", "Nombre", "Apellido", "Fecha Nacimiento", "Domicilio", "Telefono", "Cod. Inscripcion"};
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
        this.AlumnoVista.getjTF3Nombre().setText("");
        this.AlumnoVista.getjTF1Apellido().setText("");
        this.AlumnoVista.getjTF2DNI().setText("");
        this.AlumnoVista.getjTF4dlio().setText("");
        this.AlumnoVista.getjTF5Telefono().setText("");
        this.AlumnoVista.getjTextFechaNac().setText("dd-mm-aaaa");
        this.AlumnoVista.getjTF2DNI().setEditable(true);

    }
}
