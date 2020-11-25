/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaLargo;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
class Empleado {

    private int idEmpleado;
    private String Nombre_empleado;
    private String Apellido_empleado;
    private String Horario_empleado;
    private ArrayList<Venta> ventas = new ArrayList<>();
    private Factura factura;
    private ArrayList<Cliente> cliente = new ArrayList<>();

    public Empleado(int idEmpleado, String Nombre_empleado, String Apellido_empleado, String Horario_empleado) {
        this.idEmpleado = idEmpleado;
        this.Nombre_empleado = Nombre_empleado;
        this.Apellido_empleado = Apellido_empleado;
        this.Horario_empleado = Horario_empleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre_empleado() {
        return Nombre_empleado;
    }

    public void setNombre_empleado(String Nombre_empleado) {
        this.Nombre_empleado = Nombre_empleado;
    }

    public String getApellido_empleado() {
        return Apellido_empleado;
    }

    public void setApellido_empleado(String Apellido_empleado) {
        this.Apellido_empleado = Apellido_empleado;
    }

    public String getHorario_empleado() {
        return Horario_empleado;
    }

    public void setHorario_empleado(String Horario_empleado) {
        this.Horario_empleado = Horario_empleado;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }

    public void Vende() {

    }

    public void trabaja() {

    }
}
