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
class MediodeComunicacion {
    private String descripcion;
    private TipoMedio tipomedio;

    public MediodeComunicacion(String descripcion, TipoMedio tipomedio) {
        this.descripcion = descripcion;
        this.tipomedio = tipomedio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoMedio getTipomedio() {
        return tipomedio;
    }

    public void setTipomedio(TipoMedio tipomedio) {
        this.tipomedio = tipomedio;
    }

   
    
}
