/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.JF_Alumnos;
import Vista.JF_Materia;
import Vista.JF_Menu;
import Vista.JF_Cursado;
import Vista.JF_Profesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author hp
 */
public class ControladorMenu implements ActionListener {

    private JF_Menu menuPrincipal;


    ControladorMenu(JF_Menu menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        this.menuPrincipal.setLocationRelativeTo(null);
        this.menuPrincipal.getjMenu1Alumno().addActionListener(this);
        this.menuPrincipal.getjMenu2Profesor().addActionListener(this);
        this.menuPrincipal.getjMenu3Materia().addActionListener(this);
        this.menuPrincipal.getjMenu4Notas().addActionListener(this);
        this.menuPrincipal.getJmenuInscripcion().addActionListener(this);
        this.menuPrincipal.getjMenuCarreras().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.menuPrincipal.getjMenu1Alumno())) {
            Modelo.Alumno alumno = new Modelo.Alumno();
            Vista.JF_Alumnos alumnoVista = new Vista.JF_Alumnos();
            ControladorAlumno controlAlum = new ControladorAlumno(alumno, alumnoVista);
            this.menuPrincipal.dispose();
            
        }
        else if (e.getSource().equals(this.menuPrincipal.getjMenu2Profesor())) {
            Modelo.Profesor profesor=new Modelo.Profesor();
            Vista.JF_Profesor profesorVista=new Vista.JF_Profesor();
            ControladorProfesor controlProf=new ControladorProfesor(profesor, profesorVista);
            this.menuPrincipal.dispose();
        }
        else if (e.getSource().equals(this.menuPrincipal.getjMenu3Materia())) {
            Modelo.Materia materia= new Modelo.Materia();
            Vista.JF_Materia materiaVista= new Vista.JF_Materia();
            ControladorMateria controlMat= new ControladorMateria(materia, materiaVista);
            this.menuPrincipal.dispose();
        }
        else if(e.getSource().equals(this.menuPrincipal.getjMenu4Notas())){
            Modelo.Cursado cursado=new Modelo.Cursado();
            Vista.JF_Cursado cursadoVista=new Vista.JF_Cursado();
            ControladorCursado controlCursado=new ControladorCursado(cursado, cursadoVista);
            this.menuPrincipal.dispose();
        }
        else if(e.getSource().equals(this.menuPrincipal.getJmenuInscripcion())){
            Modelo.Inscripcion insc=new Modelo.Inscripcion();
            Vista.JF_Inscripcion inscVista=new Vista.JF_Inscripcion();
            ControladorInscripcion controlInsc= new ControladorInscripcion(insc, inscVista);
            this.menuPrincipal.dispose();
        }
        else if(e.getSource().equals(this.menuPrincipal.getjMenuCarreras())){
            Modelo.Carrera carrera=new Modelo.Carrera();
            Vista.JF_Carrera carreraVista=new Vista.JF_Carrera();
            ControladorCarrera controlCarrera=new ControladorCarrera(carrera, carreraVista);
            this.menuPrincipal.dispose();
        }
    }

}
