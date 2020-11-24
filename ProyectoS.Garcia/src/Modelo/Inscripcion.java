/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Datos.InscripcionDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author hp
 */
public class Inscripcion {
    
    private Carrera carrera;
    private int insc_cod;
    private String insc_nombre;
    private String insc_fecha;
    private int insc_car_cod;
    private InscripcionDAO inscripcionDAO=new InscripcionDAO();

    public Inscripcion(Carrera carrera, int insc_cod, String insc_nombre, String insc_fecha, int insc_car_cod) {
        this.carrera = carrera;
        this.insc_cod = insc_cod;
        this.insc_nombre = insc_nombre;
        this.insc_fecha = insc_fecha;
        this.insc_car_cod = insc_car_cod;
    }

    public Inscripcion() {
      
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getInsc_cod() {
        return insc_cod;
    }

    public void setInsc_cod(int insc_cod) {
        this.insc_cod = insc_cod;
    }

    public String getInsc_nombre() {
        return insc_nombre;
    }

    public void setInsc_nombre(String insc_nombre) {
        this.insc_nombre = insc_nombre;
    }

    public String getInsc_fecha() {
        return insc_fecha;
    }

    public void setInsc_fecha(String insc_fecha) {
        this.insc_fecha = insc_fecha;
    }

    public int getInsc_car_cod() {
        return insc_car_cod;
    }

    public void setInsc_car_cod(int insc_car_cod) {
        this.insc_car_cod = insc_car_cod;
    }

    public ArrayList<Inscripcion> ListadoInscripciones() {
        return inscripcionDAO.ListadoInscripcionesDAO();
    }

    public boolean AgregaInscripcion(Inscripcion inscripcion) {
       return inscripcionDAO.AgregaInscripcionDAO(inscripcion);
    }

    public boolean ModificaInscripcion(Inscripcion inscripcion) {
        return inscripcionDAO.ModificaInscripcionDAO(inscripcion);
    }

    public boolean eliminarInsc(JTable jTablaInscripciones) {
        return inscripcionDAO.EliminarInsc(jTablaInscripciones);
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

    public ArrayList<Carrera> ListadoCarreras() {
       return inscripcionDAO.ListadoCarrerasDAO();
    }
}
