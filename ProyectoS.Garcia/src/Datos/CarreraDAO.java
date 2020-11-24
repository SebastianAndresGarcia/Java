/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
 
import Modelo.Carrera;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.sql.Connection;
/**
 *
 * @author hp
 */
public class CarreraDAO extends SQLQuery {

    private ArrayList<Modelo.Carrera> carreras;
    private Modelo.Carrera carr;

    private void conexion() throws ClassNotFoundException, SQLException {
        this.conectar("localhost", "proyectoprog2020", "root", "mysql");
    }

    public boolean AgregarCarreraDAO(Carrera carrera) {
         carreras = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO carrera (car_cod, car_nombre, car_duracion) VALUES (?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setInt(1, carrera.getCar_cod());
            preparedStmt.setString(2, carrera.getCar_nombre());
            preparedStmt.setInt(3, carrera.getCar_duracion());
            preparedStmt.execute();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public ArrayList<Carrera> ListadoCarrerasDAO() {
        carreras = new ArrayList<>();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("select * from carrera");
            ResultSet hojadeResultados = consulta.executeQuery();
            while (hojadeResultados.next()) {
                carr = new Modelo.Carrera();
                carr.setCar_cod(hojadeResultados.getInt(1));
                carr.setCar_nombre(hojadeResultados.getString(2));
                carr.setCar_duracion(hojadeResultados.getInt(3));
                carreras.add(carr);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carreras;
    }

    public boolean modificaCarreraDAO(Carrera carrera) {
         try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement("UPDATE carrera SET car_nombre=? , car_duracion=? WHERE car_cod=? ");

            preparedStmt.setString(1, carrera.getCar_nombre());
            preparedStmt.setInt(2, carrera.getCar_duracion());
            preparedStmt.setInt(3, carrera.getCar_cod());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean EliminaCarreraDAO(JTable tabla) {
        int seleccion;
        carreras = new ArrayList(ListadoCarrerasDAO());
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            this.consulta = this.conn.prepareStatement("DELETE FROM Carrera WHERE car_cod=?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, carreras.get(seleccion).getCar_cod());
            
            consulta.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarreraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
