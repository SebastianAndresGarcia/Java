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
public class Proveedor extends Persona implements Estado_Cuenta{
    private String nombreComercial;

    public Proveedor(String nombreComercial, int DNI, String nombre, String apellido, long CUIT) {
        super(DNI, nombre, apellido, CUIT);
        this.nombreComercial = nombreComercial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    @Override
    public boolean problemaVerazCodeme(Boolean cuenta) {
        if(cuenta==true){System.out.println(" No se encuentra inhibido");}
        else System.out.println(" El proveedor se encuentra inhibido");
        return cuenta;
    }

   @Override
    public long getCUIT() {
        return CUIT;
    }

    @Override
    public void setCUIT(long CUIT) {
        this.CUIT = CUIT;
    }

    @Override
    public void setApellido(String apellido) {
        super.setApellido(apellido); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getApellido() {
        return super.getApellido(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDNI(int DNI) {
        super.setDNI(DNI); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDNI() {
        return super.getDNI(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
