/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Profesor;
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
public class ProfesorDAO extends SQLQuery{
    private ArrayList<Modelo.Profesor> profesores;
    private Modelo.Profesor profe;
    
     private void conexion() throws ClassNotFoundException, SQLException {
      this.conectar("localhost", "proyectoprog2020", "root", "mysql");
    }
     
    public ArrayList<Profesor> verProfesoresTodosDAO() {
       profesores = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from profesor");
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                profe = new Modelo.Profesor();
                profe.setDni(hojadeResultados.getInt(1));
                profe.setNombre(hojadeResultados.getString(2));
                profe.setApellido(hojadeResultados.getString(3));
                profe.setFecha_nac(hojadeResultados.getString(4));
                profe.setDomicilio(hojadeResultados.getString(5));
                profe.setTelefono(hojadeResultados.getString(6));
                profesores.add(profe);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesores;
    }
    public boolean registrarProfesor(Profesor profe) {
       try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO profesor (prof_dni, prof_nombre, prof_apellido, prof_fec_nac, prof_domicilio, prof_telefono) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setInt(1, profe.getDni());
            preparedStmt.setString(2, profe.getNombre());
            preparedStmt.setString(3, profe.getApellido());
            preparedStmt.setString(4, profe.getFecha_nac());
            preparedStmt.setString(5, profe.getDomicilio());
            preparedStmt.setString(6, profe.getTelefono());
            
            preparedStmt.execute();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }
    public boolean eliminarProfDAO(JTable tablaProf) {
       int seleccion;
        profesores = new ArrayList(verProfesoresTodosDAO());
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("DELETE FROM Profesor WHERE prof_dni = ?");
            seleccion = tablaProf.getSelectedRow();
            this.consulta.setInt(1, profesores.get(seleccion).getDni());
            consulta.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificarProfesorDAO(Profesor profe) {
        try {
            conexion();
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement("UPDATE Profesor SET prof_nombre=?, prof_apellido=?, prof_fec_nac=?, prof_domicilio=?, prof_telefono=? WHERE prof_dni=?");

            preparedStmt.setInt(6, profe.getDni());
            preparedStmt.setString(1, profe.getNombre());
            preparedStmt.setString(2, profe.getApellido());
            preparedStmt.setString(3, profe.getFecha_nac());
            preparedStmt.setString(4, profe.getDomicilio());
            preparedStmt.setString(5, profe.getTelefono());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
  
}
