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
public class Usuario extends Persona{
    private int idUsuario;
    private String Usuario;
    private String Password;
    private ArrayList<Contacto> contactos= new ArrayList<Contacto>(); //se parece a una composicion pero es una asociacion, debo inicializar el arraylist para que funcione

    public Usuario(int idUsuario, String Usuario, String Password, String nombre, String apellido, String idPersona) {//como la asociacion es de 0 a muchos, en el constructor no coloco un objeto de tipo Contactos, si fuera de 1 a muchos, debería colocarlo
        super(nombre, apellido, idPersona);
        this.idUsuario = idUsuario;
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    public void addContactos(Contacto contactos) {
        this.contactos.add(contactos);
    }
      
}
