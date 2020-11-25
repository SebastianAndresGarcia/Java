/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama6;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Cliente extends Persona implements Estado_Cuenta {

    private ArrayList<Tarjeta_de_credito> creditCard = new ArrayList(); //asociacion, es de cero a muchos, no lo pongo en el constructor

    public Cliente(int DNI, String nombre, String apellido, long CUIT) {
        super(DNI, nombre, apellido, CUIT);

    }

    public ArrayList<Tarjeta_de_credito> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(ArrayList<Tarjeta_de_credito> creditCard) {
        this.creditCard = creditCard;
    }

    public void addCreditCard(Tarjeta_de_credito creditCard) {
        this.creditCard.add(creditCard);
    }

    @Override
    public boolean problemaVerazCodeme(Boolean cuenta) {
        if (cuenta == true) {
            System.out.println("No está inhibido");

        }
        if (cuenta == false) {
            System.out.println("Cliente y tarjeta inhibidos");

        }
        return cuenta;
    }

    @Override
    public long getCUIT() {
        return CUIT;
    }

    @Override
    public void setCUIT(long CUIT) {
        this.CUIT = CUIT;
    }
}
