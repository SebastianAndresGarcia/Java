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
class ContactoTipo {
    private int idContactoTipo;
    private String descripcion;

    public ContactoTipo(int idContactoTipo, String descripcion) {
        this.idContactoTipo = idContactoTipo;
        this.descripcion = descripcion;
    }

    public int getIdContactoTipo() {
        return idContactoTipo;
    }

    public void setIdContactoTipo(int idContactoTipo) {
        this.idContactoTipo = idContactoTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
