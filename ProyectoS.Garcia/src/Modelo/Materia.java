/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.MateriaDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author hp
 */
public class Materia {

    private int mat_cod;
    private String mat_nombre;
    private int mat_prof_dni;
    private MateriaDAO materiaDAO = new MateriaDAO();

    public Materia(int mat_cod, String mat_nombre, int mat_prof_dni) {
        this.mat_cod = mat_cod;
        this.mat_nombre = mat_nombre;
        this.mat_prof_dni = mat_prof_dni;
    }

    public Materia() {
    }

    public int getMat_cod() {
        return mat_cod;
    }

    public void setMat_cod(int mat_cod) {
        this.mat_cod = mat_cod;
    }

    public String getMat_nombre() {
        return mat_nombre;
    }

    public void setMat_nombre(String mat_nombre) {
        this.mat_nombre = mat_nombre;
    }

    public int getMat_prof_dni() {
        return mat_prof_dni;
    }

    public void setMat_prof_dni(int mat_prof_dni) {
        this.mat_prof_dni = mat_prof_dni;
    }

    public ArrayList<Modelo.Materia> ListadoMaterias() {
        return materiaDAO.ListadoMateriasDAO();
    }

    public boolean agregarMateria(Materia materia) {
        return materiaDAO.agregarMateriaDAO(materia);
    }

    public boolean ModificaMateria(Materia materia) {
        return materiaDAO.ModificaMateriaDAO(materia);
    }

    public boolean EliminaMateria(JTable materia) {
        return materiaDAO.EliminaMateriaDAO(materia);
    }

    public boolean codigoExistente(int codigo) {
        boolean repetido = false;
        ArrayList<Materia> materia = materiaDAO.ListadoMateriasDAO();
        for (int i = 0; i < materia.size(); i++) {
            if (materia.get(i).mat_cod == codigo) {
                repetido = true;
            }
        }
        return repetido;
    }

    public ArrayList<Modelo.Profesor> DNIProfe() {
                
        return materiaDAO.DNIProfeDAO();
    
    }

    public boolean validarMateria(String mat_nombre) {
        boolean repetido = false;
        ArrayList<Materia> materia = materiaDAO.ListadoMateriasDAO();
        for (int i = 0; i < materia.size(); i++) {
            if (materia.get(i).getMat_nombre().equals(mat_nombre)) {
                repetido = true;
            }
        }
        return repetido;
    }

}
