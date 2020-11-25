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
class TipoMedio {
    private String nombreMedio;
    private String tipo; // 

    public TipoMedio(String nombreMedio, String tipo) {
        this.nombreMedio = nombreMedio;
        this.tipo = tipo;
    }

    public String getNombreMedio() {
        return nombreMedio;
    }

    public void setNombreMedio(String nombreMedio) {
        this.nombreMedio = nombreMedio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
