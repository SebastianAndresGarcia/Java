/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama6;

/**
 *
 * @author hp
 */
public abstract class Persona {
    protected int DNI;
    protected String nombre;
    protected String apellido;
    protected long CUIT;

    public Persona(int DNI, String nombre, String apellido, long CUIT) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUIT = CUIT;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public abstract long getCUIT();

    public abstract void setCUIT(long CUIT);    
}
