/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaLargo;

/**
 *
 * @author hp
 */
class Productos {
    private int Idproductos;
    private double precio;
    private String Descripcion;
    private String nombre;

    public Productos(int Idproductos, double precio, String Descripcion, String nombre) {
        this.Idproductos = Idproductos;
        this.precio = precio;
        this.Descripcion = Descripcion;
        this.nombre = nombre;
    }

    public int getIdproductos() {
        return Idproductos;
    }

    public void setIdproductos(int Idproductos) {
        this.Idproductos = Idproductos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void vende(){
        
    }
}
