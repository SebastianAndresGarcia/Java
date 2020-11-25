/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import Modelo.Alumno;
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
public class AlumnoDAO extends SQLQuery {

    private ArrayList<Modelo.Alumno> alumnos = new ArrayList<>();
    private Modelo.Alumno alum;
    
    private void conexion() throws ClassNotFoundException, SQLException {
      this.conectar("localhost", "proyectoprog2020", "root", "mysql");
    }
    public boolean registrarAlumnoDAO(Modelo.Alumno alum) {
        
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO alumno (alu_dni, alu_nombre, alu_apellido, alu_fec_nac, alu_domicilio, alu_telefono, alu_insc_cod) VALUES (?,?,?,?,?,?,?)";
         
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setInt(1, alum.getDni());
            preparedStmt.setString(2, alum.getNombre());
            preparedStmt.setString(3, alum.getApellido());
            preparedStmt.setString(4, alum.getFecha_nac());
            preparedStmt.setString(5, alum.getDomicilio());
            preparedStmt.setString(6, alum.getTelefono());
            preparedStmt.setInt(7, alum.getInsc_cod());
            preparedStmt.execute();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }

    }

    public ArrayList<Modelo.Alumno> verAlumnosTodosDAO() {
        alumnos = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from alumno");
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                alum = new Modelo.Alumno();
                alum.setDni(hojadeResultados.getInt(1));
                alum.setNombre(hojadeResultados.getString(2));
                alum.setApellido(hojadeResultados.getString(3));
                alum.setFecha_nac(hojadeResultados.getString(4));
                alum.setDomicilio(hojadeResultados.getString(5));
                alum.setTelefono(hojadeResultados.getString(6));
                alum.setInsc_cod(hojadeResultados.getInt(7));
                alumnos.add(alum);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alumnos;
    }

    public boolean eliminarAlumnoDAO(JTable tablaAlumnos) {
        int seleccion;
        alumnos = new ArrayList(verAlumnosTodosDAO());
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            this.consulta = this.conn.prepareStatement("DELETE FROM Alumno WHERE alu_dni = ?");
            seleccion = tablaAlumnos.getSelectedRow();
            this.consulta.setInt(1, alumnos.get(seleccion).getDni());
            consulta.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean modificarAlumnoDAO(Modelo.Alumno alum) {

        try {
            conexion();
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement("UPDATE Alumno SET alu_nombre=?, alu_apellido=?,alu_fec_nac=?, alu_domicilio=?, alu_telefono=? WHERE alu_dni=?");

            preparedStmt.setInt(6, alum.getDni());
            preparedStmt.setString(1, alum.getNombre());
            preparedStmt.setString(2, alum.getApellido());
            preparedStmt.setString(3, alum.getFecha_nac());
            preparedStmt.setString(4, alum.getDomicilio());
            preparedStmt.setString(5, alum.getTelefono());
            //preparedStmt.setInt(7, alum.getInsc_cod());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
