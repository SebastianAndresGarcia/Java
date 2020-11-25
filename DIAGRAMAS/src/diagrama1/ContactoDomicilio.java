/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama1;

/**
 *
 * @author hp
 */
public class ContactoDomicilio {

    private int idContactoDomilio;
    private String descripcion;

    public ContactoDomicilio(int idContactoDomilio, String descripcion) {
        this.idContactoDomilio = idContactoDomilio;
        this.descripcion = descripcion;
    }

    public int getIdContactoDomilio() {
        return idContactoDomilio;
    }

    public void setIdContactoDomilio(int idContactoDomilio) {
        this.idContactoDomilio = idContactoDomilio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
