/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama3;

import java.util.Scanner;

/**
 *
 * @author hp
 */
public class main {
//Debo crear adentro de comprobante un new de fecha y adentro de recibo un new de proveedor 
//para cumplir con la composición que marca el diagrama. Como la fecha dice 1....1 debe haber 
//una fecha dentro de comprobante, un proveedor dentro de recibo
    public static void main(String[] args) {
        //      Proveedor proveedor, double total, String detalle, char tipo, int numero, Fecha fecha
        Recibo recibo = new Recibo(new Proveedor(0, ""), 100.99, "fideos", 'A', 1, new Fecha(0, 0, 0));
        System.out.println("Ingrese el número de Comprobante ");
        Comprobante C1 = new Comprobante('B', 1, new Fecha(0, 0, 0));
        Scanner S=new Scanner(System.in);
        C1.setNumero(S.nextInt());
        recibo = new Recibo(new Proveedor(0, ""), 100.99, "fideos", C1.getTipo(),C1.getNumero(),C1.getFecha());
        System.out.println("Ingrese la fecha\nDía");
        recibo.getFecha().setDia(S.nextInt());
        System.out.println("Mes ");
        recibo.getFecha().setDia(S.nextInt());
        System.out.println("Año "); recibo.getFecha().setAnio(S.nextInt());
        System.out.println("Ingrese nombre del proveedor ");
        recibo.getProveedor().setRazonSocial(new Scanner(System.in).nextLine());
        recibo.getProveedor().setCodigo(1);
        System.out.println("Recibo Tipo "+recibo.getTipo()+"\nNumero "+recibo.getNumero());
        
    }
}
