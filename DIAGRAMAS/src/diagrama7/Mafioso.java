/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama7;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Mafioso extends Persona implements Investigable {

    private ArrayList<Lugar> lugaresfrecuentes = new ArrayList<Lugar>();

    public Mafioso(String nombre, String apellido, Foto foto) {
        super(nombre, apellido, foto);
    }

    public ArrayList<Lugar> getLugaresfrecuentes() {
        return lugaresfrecuentes;
    }

    public void setLugaresfrecuentes(ArrayList<Lugar> lugaresfrecuentes) {
        this.lugaresfrecuentes = lugaresfrecuentes;
    }

    public void agregarLugar(Lugar lugar) {
        this.lugaresfrecuentes.add(lugar);
    }

    public boolean quitarLugar(Lugar lugar) {
        return lugaresfrecuentes.remove(lugar);
    }

    @Override
    public Boolean investigar() {
        return true;
    }

}
