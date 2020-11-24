/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Datos.CarreraDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author hp
 */
public class Carrera {
    
    private int car_cod;
    private String car_nombre;
    private int car_duracion;
    private CarreraDAO carreraDAO=new CarreraDAO();
    
    public Carrera(int car_cod, String car_nombre, int car_duracion) {
        this.car_cod = car_cod;
        this.car_nombre = car_nombre;
        this.car_duracion = car_duracion;
    }

    public Carrera() {

    }

    public int getCar_cod() {
        return car_cod;
    }

    public void setCar_cod(int car_cod) {
        this.car_cod = car_cod;
    }

    public String getCar_nombre() {
        return car_nombre;
    }

    public void setCar_nombre(String car_nombre) {
        this.car_nombre = car_nombre;
    }

    public int getCar_duracion() {
        return car_duracion;
    }

    public void setCar_duracion(int car_duracion) {
        this.car_duracion = car_duracion;
    }

    public boolean AgregarCarrera(Carrera carrera) {
        return carreraDAO.AgregarCarreraDAO(carrera);
    }

    public ArrayList<Carrera> ListadoCarreras() {
        return carreraDAO.ListadoCarrerasDAO();
    }

    public boolean ModificaCarrera(Carrera carrera) {
        return carreraDAO.modificaCarreraDAO(carrera);
    }

    public boolean EliminaCarrera(JTable tablecarrera) {
        return carreraDAO.EliminaCarreraDAO(tablecarrera);
    }
    
}
