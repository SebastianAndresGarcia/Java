/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama5;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Rueda {
   int rueda;
   String tipo;

    public Rueda(int rueda, String tipo) {
        this.rueda = rueda;
        this.tipo=tipo;
    }

    public int getRueda() {
        return rueda;
    }

    public void setRueda(int rueda) {
        this.rueda = rueda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
