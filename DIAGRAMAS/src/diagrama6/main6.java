/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama6;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class main6 {  //desde factura puedo llegar a todas las otras clases menos a proveedor

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        //  DNI,   nombre,   apellido,   CUIT
        Cliente c1 = new Cliente(33456789, "", "", 2033456789);
        //( nroFactura,   fecha,   monto, Empleado  , Cliente  )
        Factura factura = new Factura(1, new Date(), 1599);
        Empleado Emp=new Empleado(new Date(), 1, 1, "", "", 2500000);
        // nombreComercial,  DNI,  nombre,  apellido, long CUIT
        Proveedor P = new Proveedor("ARCOR", 34000000, "Sergio", "Sanchez", 234444444);
        factura.getClie().setNombre("Juan");
        factura.getClie().setApellido("Sanchez");
        factura.getClie().setDNI(30345876);
        factura.getClie().addCreditCard(new Tarjeta_de_credito(new Date(), 20000));
        factura.getEmp().setNombre("Ale");
        factura.getEmp().setApellido("Gomez");
        factura.getEmp().setLegajo(5968);
        factura.getClie().getCreditCard().add(new Tarjeta_de_credito(new Date(),30000));
        System.out.print("El cliente " + factura.getClie().getApellido() + " " + factura.getClie().getDNI() + " ");
        factura.getClie().problemaVerazCodeme(true);
        System.out.print("Proveedor: "+P.getNombreComercial());
        System.out.print(" Cuit "+P.getCUIT()+" ");
        P.problemaVerazCodeme(true);
        System.out.println("Tarjetas del Cliente "+ factura.getClie().getDNI());
        System.out.println("Limete "+factura.getClie().getCreditCard().get(0).getLimite());
        System.out.println("Limite "+factura.getClie().getCreditCard().get(1).getLimite());
    }
}
