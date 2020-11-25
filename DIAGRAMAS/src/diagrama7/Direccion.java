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
class Direccion {
    private String calle;
    private int numeroDlio;

    public Direccion(String calle, int numeroDlio) {
        this.calle = calle;
        this.numeroDlio = numeroDlio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroDlio() {
        return numeroDlio;
    }

    public void setNumeroDlio(int numeroDlio) {
        this.numeroDlio = numeroDlio;
    }
    
}
