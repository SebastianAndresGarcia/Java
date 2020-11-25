/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama6;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Empleado extends Persona {

    private Date fecha_ingreso;
    private int Legajo;

    public Empleado(Date fecha_ingreso, int Legajo, int DNI, String nombre, String apellido, long CUIT) {
        super(DNI, nombre, apellido, CUIT);
        this.fecha_ingreso = fecha_ingreso;
        this.Legajo = Legajo;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getLegajo() {
        return Legajo;
    }

    public void setLegajo(int Legajo) {
        this.Legajo = Legajo;
    }

    @Override
    public long getCUIT() {
        return CUIT;
    }

    @Override
    public void setCUIT(long CUIT) {
        this.CUIT = CUIT;
    }

}
