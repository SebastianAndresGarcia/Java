/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Carrera;
import Modelo.Inscripcion;
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
public class InscripcionDAO extends SQLQuery {

    private ArrayList<Modelo.Inscripcion> inscripciones;
    private Modelo.Inscripcion insc;
    private ArrayList<Modelo.Carrera> carreras;
    private void conexion() throws ClassNotFoundException, SQLException {
        this.conectar("localhost", "proyectoprog2020", "root", "mysql");
    }

    public ArrayList<Inscripcion> ListadoInscripcionesDAO() {

        inscripciones = new ArrayList<>();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            this.consulta = this.conn.prepareStatement("select * from inscripcion");
            ResultSet hojadeResultados = consulta.executeQuery();
            while (hojadeResultados.next()) {
                insc = new Modelo.Inscripcion();
                insc.setInsc_cod(hojadeResultados.getInt(1));
                insc.setInsc_nombre(hojadeResultados.getString(2));
                insc.setInsc_fecha(hojadeResultados.getString(3));
                insc.setInsc_car_cod(hojadeResultados.getInt(4));
                inscripciones.add(insc);
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inscripciones;
    }

    public boolean AgregaInscripcionDAO(Inscripcion insc) {
        inscripciones = new ArrayList();
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            String sql = "INSERT INTO inscripcion (insc_cod, insc_nombre, insc_fecha, insc_car_cod) VALUES (?,?,?,?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement(sql);
            preparedStmt.setInt(1, insc.getInsc_cod());
            preparedStmt.setString(2, insc.getInsc_nombre());
            preparedStmt.setString(3, insc.getInsc_fecha());
            preparedStmt.setInt(4, insc.getInsc_car_cod());

            preparedStmt.execute();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean ModificaInscripcionDAO(Inscripcion insc) {
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            PreparedStatement preparedStmt = (PreparedStatement) this.conn.prepareStatement("UPDATE inscripcion SET insc_nombre=? , insc_fecha=?, insc_car_cod=? WHERE insc_cod=?");

            preparedStmt.setString(1, insc.getInsc_nombre());
            preparedStmt.setString(2, insc.getInsc_fecha());
            preparedStmt.setInt(4, insc.getInsc_cod());
            preparedStmt.setInt(3, insc.getInsc_car_cod());

            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean EliminarInsc(JTable tabla) {
        int seleccion;
        inscripciones = new ArrayList(ListadoInscripcionesDAO());
        try {
            conexion();
            this.consulta = this.conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
            this.datos = this.consulta.executeQuery();
            this.consulta = this.conn.prepareStatement("DELETE FROM Inscripcion WHERE insc_cod=?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, inscripciones.get(seleccion).getInsc_cod());
            consulta.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Modelo.Carrera carr = new Modelo.Carrera();
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

}
