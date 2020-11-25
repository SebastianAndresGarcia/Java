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
public class Detective extends Persona{
    private String numeroPlaca;

    public Detective(String numeroPlaca, String nombre, String apellido, Foto foto) {
        super(nombre, apellido, foto);
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }
    public Boolean investigarMafioso(Mafioso mafioso){
        
        return mafioso.investigar();
      
    }
}
