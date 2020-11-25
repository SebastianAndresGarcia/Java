/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama7;

/**
 *
 * @author hp
 */
class Foto {
    private String PathtoFile;
    private String nombre;
    private float tamanio;

    public Foto(String PathtoFile, String nombre, float tamanio) {
        this.PathtoFile = PathtoFile;
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    public String getPathtoFile() {
        return PathtoFile;
    }

    public void setPathtoFile(String PathtoFile) {
        this.PathtoFile = PathtoFile;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTamanio() {
        return tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }
   
}
