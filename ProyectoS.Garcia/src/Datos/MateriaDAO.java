/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Modelo.Profesor;
import Modelo.Materia;
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
public class MateriaDAO extends SQLQuery {

    private ArrayList<Modelo.Materia> materias=new ArrayList<>();
    private Modelo.Materia mat;
    
    private void conexion() throws ClassNotFoundException, SQLException {
        this.conectar("localhost", "proyectoprog2020", "root", "mysql");
    }

    public ArrayList<Modelo.Materia> ListadoMateriasDAO() {
        materias = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from materia");
            ResultSet hojadeResultados = consulta.executeQuery();
            while (hojadeResultados.next()) {
                mat = new Modelo.Materia();
                mat.setMat_cod(hojadeResultados.getInt(1));
                mat.setMat_nombre(hojadeResultados.getString(2));
                mat.setMat_prof_dni(hojadeResultados.getInt(3));
                materias.add(mat);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }

    public boolean agregarMateriaDAO(Materia mat) {
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO materia (mat_cod, mat_nombre, mat_prof_dni) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setInt(1, mat.getMat_cod());
            preparedStmt.setString(2, mat.getMat_nombre());
            preparedStmt.setInt(3, mat.getMat_prof_dni());

            preparedStmt.execute();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean ModificaMateriaDAO(Materia mat) {
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement("UPDATE Materia SET mat_nombre=?, mat_prof_dni=? WHERE mat_cod=?");
            preparedStmt.setInt(3, mat.getMat_cod());
            preparedStmt.setString(1, mat.getMat_nombre());
            preparedStmt.setInt(2, mat.getMat_prof_dni());

            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean EliminaMateriaDAO(JTable tablamateria) {
        int seleccion;
        materias = new ArrayList(ListadoMateriasDAO());
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            this.consulta = this.conn.prepareStatement("DELETE FROM Materia WHERE mat_cod= ?");
            seleccion = tablamateria.getSelectedRow();
            this.consulta.setLong(1, materias.get(seleccion).getMat_cod());
            consulta.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Modelo.Profesor> DNIProfeDAO() {
        ArrayList<Modelo.Profesor> dni=new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from profesor");
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                Modelo.Profesor profe = new Modelo.Profesor();
                profe.setDni(hojadeResultados.getInt(1));
                profe.setApellido(hojadeResultados.getString(3));
                profe.setNombre(hojadeResultados.getString(2));
                dni.add(profe); 
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dni;
    }
}
