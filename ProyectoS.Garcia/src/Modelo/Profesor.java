/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.ProfesorDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author hp
 */
public class Profesor extends Persona {

    private int dni;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    private String fecha_nac;
    private int insc_cod;
    private ProfesorDAO profesorDAO = new ProfesorDAO();

    public Profesor(int dni, String nombre, String apellido, String domicilio, String telefono, String fecha_nac, int insc_cod) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        this.insc_cod = insc_cod;
    }

    public Profesor() {
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

    public ArrayList<Modelo.Profesor> verProfesoresTodos() {
        return profesorDAO.verProfesoresTodosDAO();
    }

    public boolean revisarDNI(int DNI) {
        boolean repetido = false;
        ArrayList<Profesor> profesor = profesorDAO.verProfesoresTodosDAO();
        for (int i = 0; i < profesor.size(); i++) {
            if (profesor.get(i).getDni() == DNI) {
                repetido = true;
            }
        }
        return repetido;
    }

    public boolean registrarProfesor(Profesor profesor) {
        return profesorDAO.registrarProfesor(profesor);
    }

    public boolean modificarProfesor(Profesor profesor) {
        return profesorDAO.modificarProfesorDAO(profesor);
    }

    public boolean eliminarProf(JTable profesor) {
        return profesorDAO.eliminarProfDAO(profesor);
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
