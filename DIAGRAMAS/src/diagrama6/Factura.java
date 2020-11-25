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
public class Factura {

    private Empleado emp = new Empleado(new Date(), 1, 1, "", "", 1000000000); //composición  System.out.println(utilDate);
    private Cliente clie = new Cliente(1, "", "", 1); // composicion   si es composición no va en el constructor y el diagrama tiene un error
    private int nroFactura;
    private Date fecha;
    private double monto;

    public Factura(int nroFactura, Date fecha, double monto) {
        this.nroFactura = nroFactura;
        this.fecha = fecha;
        this.monto = monto;
       
        
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public Cliente getClie() {
        return clie;
    }

    public void setClie(Cliente clie) {
        this.clie = clie;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
