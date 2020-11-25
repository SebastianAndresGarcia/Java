/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama6;

import java.util.Date;

/**
 *
 * @author hp
 */
class Tarjeta_de_credito {
    private Date fecha_ingreso;
    private double limite;

    public Tarjeta_de_credito(Date fecha_ingreso, double limite) {
        this.fecha_ingreso = fecha_ingreso;
        this.limite = limite;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
}
