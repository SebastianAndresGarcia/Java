/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Datos.CursadoDAO;
import java.util.ArrayList;
import javax.swing.JTable;
/**
 *
 * @author hp
 */
public class Cursado {
    private int cur_nota;
    private int cur_alu_dni;
    private int cur_mat_cod;
    
    private CursadoDAO cursadoDAO=new CursadoDAO();

    public Cursado(int cur_nota, int cur_alu_dni, int cur_mat_cod) {
        this.cur_nota = cur_nota;
        this.cur_alu_dni = cur_alu_dni;
        this.cur_mat_cod = cur_mat_cod;
    }

    public int getCur_alu_dni() {
        return cur_alu_dni;
    }

    public void setCur_alu_dni(int cur_alu_dni) {
        this.cur_alu_dni = cur_alu_dni;
    }

    public int getCur_mat_cod() {
        return cur_mat_cod;
    }

    public void setCur_mat_cod(int cur_mat_cod) {
        this.cur_mat_cod = cur_mat_cod;
    }

    public Cursado() {

    }

    public int getCur_nota() {
        return cur_nota;
    }

    public void setCur_nota(int cur_nota) {
        this.cur_nota = cur_nota;
    }

    public CursadoDAO getCursadoDAO() {
        return cursadoDAO;
    }

    public void setCursadoDAO(CursadoDAO cursadoDAO) {
        this.cursadoDAO = cursadoDAO;
    }


    public ArrayList<Cursado> DatoCursado() {
       return cursadoDAO.DatosCursadoDAO();
    }

    public boolean agregarNota(Modelo.Cursado nota) {
        return cursadoDAO.agregarNotaDAO(nota);
    }

    public boolean modificaNota(Modelo.Cursado cursado) {
       return cursadoDAO.modificaNotaDAO(cursado);
    }

    public ArrayList<Modelo.Alumno> DNIAlumno() {
       return cursadoDAO.DNIAlumnoDAO();
    }

    public ArrayList<Modelo.Materia> DatosMateria() {
        return cursadoDAO.DatosMateriaDAO();
    }

    public boolean EliminarNota(JTable tabla) {
        return cursadoDAO.EliminarNotaDAO(tabla);
    }

     public boolean validarMateria(Cursado c) {
        boolean repetido = false;
        ArrayList<Cursado> cursado = cursadoDAO.DatosCursadoDAO();
        for (int i = 0; i < cursado.size(); i++) {
            if (cursado.get(i).getCur_mat_cod()==c.cur_mat_cod&&cursado.get(i).getCur_alu_dni()==c.cur_alu_dni) {
                repetido = true;
            }
        }
        return repetido;
    }

  
}
