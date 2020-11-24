/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Alumno;
import Modelo.Materia;
import Modelo.Cursado;
import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author hp
 */
public class CursadoDAO extends SQLQuery {

    private ArrayList<Modelo.Cursado> cursados = new ArrayList<>();
    private Modelo.Cursado nota;
  
    private void conexion() throws ClassNotFoundException, SQLException {
        this.conectar("localhost", "proyectoprog2020", "root", "mysql");
    }

    public ArrayList<Modelo.Alumno> DNIAlumnoDAO() {
        ArrayList<Modelo.Alumno> dni = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from alumno");
            ResultSet hojadeResultados = consulta.executeQuery();
            
            while (hojadeResultados.next()) {
                Modelo.Alumno a=new Modelo.Alumno();
                a.setDni(hojadeResultados.getInt(1));
                a.setNombre(hojadeResultados.getString(2));
                a.setApellido(hojadeResultados.getString(3));
                dni.add(a);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dni;
    }

    public ArrayList<Modelo.Materia> DatosMateriaDAO() {
        ArrayList<Modelo.Materia> materia = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from materia");
            ResultSet hojadeResultados = consulta.executeQuery();
            
            while (hojadeResultados.next()) {
                Modelo.Materia m=new Modelo.Materia();
                m.setMat_cod(hojadeResultados.getInt(1));
                m.setMat_nombre(hojadeResultados.getString(2));
                materia.add(m);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materia;
    }

    public ArrayList<Cursado> DatosCursadoDAO() {
        cursados = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from cursado");
            ResultSet hojadeResultados = consulta.executeQuery();
            while (hojadeResultados.next()) {
                nota = new Modelo.Cursado();

                nota.setCur_alu_dni(hojadeResultados.getInt(1));
                nota.setCur_mat_cod(hojadeResultados.getInt(2));
                nota.setCur_nota(hojadeResultados.getInt(3));
                cursados.add(nota);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursados;
    }

    public boolean agregarNotaDAO(Modelo.Cursado nota) {
        
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO cursado (cur_alu_dni, cur_mat_cod, cur_nota) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setInt(1, nota.getCur_alu_dni());
            preparedStmt.setInt(2, nota.getCur_mat_cod());
            preparedStmt.setInt(3, nota.getCur_nota());

            preparedStmt.execute();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean modificaNotaDAO(Cursado nota) {
        try {
            conexion();
           
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement("UPDATE Cursado SET cur_nota=? WHERE cur_alu_dni=? AND cur_mat_cod=?");
            preparedStmt.setInt(1, nota.getCur_nota());
            preparedStmt.setInt(2, nota.getCur_alu_dni());
            preparedStmt.setInt(3, nota.getCur_mat_cod());

            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean EliminarNotaDAO(JTable tabla) {
     int seleccion;
        cursados = new ArrayList(DatosCursadoDAO());
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            this.consulta = this.conn.prepareStatement("DELETE FROM Cursado WHERE cur_alu_dni= ? AND cur_mat_cod=?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setInt(1, cursados.get(seleccion).getCur_alu_dni());
            this.consulta.setInt(2, cursados.get(seleccion).getCur_mat_cod());
            consulta.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
