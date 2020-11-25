/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiagramaLargo;

/**
 *
 * @author hp
 */
class SistemaDePago {
    private int IDventa;
    private String TipodeCredito;
    private String Estado;
    private String restricciones;

    public SistemaDePago(int IDventa, String TipodeCredito, String Estado, String restricciones) {
        this.IDventa = IDventa;
        this.TipodeCredito = TipodeCredito;
        this.Estado = Estado;
        this.restricciones = restricciones;
    }

    public int getIDventa() {
        return IDventa;
    }

    public void setIDventa(int IDventa) {
        this.IDventa = IDventa;
    }

    public String getTipodeCredito() {
        return TipodeCredito;
    }

    public void setTipodeCredito(String TipodeCredito) {
        this.TipodeCredito = TipodeCredito;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }
    public void Realiza(){
        
    }
    public void actualiza(){
        
    }
}
