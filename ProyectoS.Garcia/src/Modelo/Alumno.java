/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.AlumnoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
/**
 *
 * @author hp
 */
public class Alumno extends Persona {

    private int dni;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    private String fecha_nac;
    private int insc_cod;
    private AlumnoDAO alumnoDAO = new AlumnoDAO();

    public Alumno(int dni, String nombre, String apellido, String domicilio, String telefono, String fecha_nac, int insc_cod) {
        super(dni, nombre, apellido, domicilio, telefono, fecha_nac, insc_cod);
    }
    
    public Alumno() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getInsc_cod() {
        return insc_cod;
    }

    public void setInsc_cod(int insc_cod) {
        this.insc_cod = insc_cod;
    }

    public boolean registrarAlumno(Alumno alumno){
        return alumnoDAO.registrarAlumnoDAO(alumno);
    }
   

    public ArrayList<Modelo.Alumno> verAlumnosTodos() {
        return alumnoDAO.verAlumnosTodosDAO();
    }

    public boolean modificarAlumno(Alumno alumno) {
        return alumnoDAO.modificarAlumnoDAO(alumno);
    }

    public boolean eliminarAlumno(JTable alumno) {
       return alumnoDAO.eliminarAlumnoDAO(alumno);
    }

    public boolean revisarDNI(int DNI) {
        boolean repetido=false;
        ArrayList<Alumno> alumno=alumnoDAO.verAlumnosTodosDAO();
        for (int i = 0; i < alumno.size(); i++) {
            if(alumno.get(i).getDni()==DNI){
                repetido=true;
            }
        }
        return repetido;
    }

    public String formatoFecha(String fecha_nac) {
        String anio = "", mes = "", dia = "";
        for (int i = 0; i < fecha_nac.length(); i++) {
            if (i < 4) {
                anio = anio + fecha_nac.charAt(i);
            }
            if (i > 4 && i < 7) {
                mes = mes + fecha_nac.charAt(i);
            }
            if (i > 7) {
                dia = dia + fecha_nac.charAt(i);
            }
        }
        return (dia + "-" + mes + "-" + anio);
    }

    public String fechaSQL(String fecha_nac) {
        String anio = "", mes = "", dia = "";
        for (int i = 0; i < fecha_nac.length(); i++) {
            if (i > 5) {
                anio = anio + fecha_nac.charAt(i);
            }
            if (i > 2 && i < 5) {
                mes = mes + fecha_nac.charAt(i);
            }
            if (i < 3) {
                dia = dia + fecha_nac.charAt(i);
            }
        }
        return (anio + "-" + mes + "-" + dia);
    }

    public boolean validarFechaNac(String dateString) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            df.parse(dateString);
            
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
