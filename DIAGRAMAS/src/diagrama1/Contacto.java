/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama1;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Contacto extends Persona {
    private int idContacto;
    private ContactoTipo tipo;
    private ArrayList<ContactoDomicilio> domicilio=new ArrayList<ContactoDomicilio>();
    private ArrayList<ContactoTelefono> telefono=new ArrayList<ContactoTelefono>();

     public Contacto(int idContacto, ContactoTipo tipo, String nombre, String apellido, String idPersona) {
        super(nombre, apellido, idPersona);
        this.idContacto = idContacto;
        this.tipo = tipo;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public ContactoTipo getTipo() {
        return tipo;
    }

    public void setTipo(ContactoTipo tipo) {
        this.tipo = tipo;
    }

    public ArrayList<ContactoDomicilio> getDomicilio() {
        return domicilio;
    }

    public void addDomicilio(ContactoDomicilio domicilio) {
        this.domicilio.add(domicilio);
    }

    public ArrayList<ContactoTelefono> getTelefono() {
        return telefono;
    }

    public void addTelefono(ContactoTelefono telefono) {
        this.telefono.add(telefono);
    }

    public void setDomicilio(ArrayList<ContactoDomicilio> domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelefono(ArrayList<ContactoTelefono> telefono) {
        this.telefono = telefono;
    }
    
}
