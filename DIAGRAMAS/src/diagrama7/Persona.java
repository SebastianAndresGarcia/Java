/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class Persona {

    private String nombre;
    private String apellido;
    private Foto foto;
    private ArrayList<MediodeComunicacion> comunicaciones = new ArrayList<MediodeComunicacion>(); //asociacion
    private ArrayList<Perfil> perfiles = new ArrayList<Perfil>(); //composición  si es composición no va en el constructor y el diagrama tiene un error

    public Persona(String nombre, String apellido, Foto foto) {
        //como la asociacion es de 1 a muchos debo inicializarlo en el constructor, coloco un objeto de tipo MediodeComunicacion
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;

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

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public ArrayList<MediodeComunicacion> getComunicaciones() {
        return comunicaciones;
    }

    public void setComunicaciones(ArrayList<MediodeComunicacion> comunicaciones) {
        this.comunicaciones = comunicaciones;
    }

    public void addsetComunicaciones(MediodeComunicacion comunicaciones) {
        this.comunicaciones.add(comunicaciones);
    }

    public ArrayList<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(ArrayList<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    public void agregarPerfil(Perfil perfiles) {
        this.perfiles.add(perfiles);
    }

    public void quitarPerfil(int indice) {
        this.perfiles.remove(perfiles);
    }
}
