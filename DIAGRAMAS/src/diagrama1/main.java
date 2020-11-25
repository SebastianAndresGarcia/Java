/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama1;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class main {
    
    public static void main(String[] args) {
        Contacto c1 = new Contacto(111, new ContactoTipo(2, "compañeroTrabajo"), "Lucas", "Castro", "30000000");
        Usuario u1 = new Usuario(5968, "user", "1234", "Sebastian", "Garcia", "33577343");
        u1.addContactos(c1);
        System.out.println("Usuario logueado: " + u1.getNombre() + " " + u1.getApellido());
        u1.getContactos().get(0).getTipo().setDescripcion("amigodeFutbol");
        System.out.println("Contacto n° " + u1.getContactos().get(0).getTipo().getIdContactoTipo()+"("+ u1.getContactos().get(0).getTipo().getDescripcion()+")"+": "); //le pido al arraylist que me mande el de la posicion 0
        System.out.println("Ingrese el teléfono del contacto "+u1.getContactos().get(0).getNombre()+" " + u1.getContactos().get(0).getApellido());
        
        
        Scanner S = new Scanner(System.in);
        u1.getContactos().get(0).addTelefono(new ContactoTelefono(0, "261", S.nextLine()));
        u1.getContactos().get(0).addDomicilio(new ContactoDomicilio(560,"calle San Martín de Ciudad"));
        System.out.println("Domicilio: "+u1.getContactos().get(0).getDomicilio().get(0).getDescripcion()+" "
        +u1.getContactos().get(0).getDomicilio().get(0).getIdContactoDomilio());
        
        System.out.println("Ingrese un nuevo contacto: \n Nombre: ");
        Contacto c2 = new Contacto(2453, new ContactoTipo(1, " "), S.nextLine(), "", "");
        u1.addContactos(c2);
        System.out.println("Apellido: ");
        u1.getContactos().get(1).setApellido(S.nextLine());
        System.out.println("Teléfono");
        ContactoTelefono telefono=new ContactoTelefono(1,"261",S.nextLine());
        u1.getContactos().get(1).addTelefono(telefono);
       
        u1.getContactos().get(1).addDomicilio(new ContactoDomicilio(424,"calle Civit de Luján"));
        System.out.println("Domicilio: "+u1.getContactos().get(1).getDomicilio().get(0).getDescripcion()+" "
        +u1.getContactos().get(1).getDomicilio().get(0).getIdContactoDomilio());
        
    }
}
