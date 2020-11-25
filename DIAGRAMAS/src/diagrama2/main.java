/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrama2;

/**
 *
 * @author hp
 */
public class main {
     public static void main(String[] args) {
         //Factura               total,       mCliente,         tipo,numero,   Fecha                     mProducto
         //                                 cod  razon social                                       cod. descripcion precio
         Factura f1=new Factura(1000,new Cliente(1,"Restaurant"),'a',1,new Fecha(18,4,2020), new Producto(1,"Cafe",11.99));
         f1.getFecha().setDia(19);
         Comprobante comprobante=new Comprobante('A',1,f1.getFecha());
         f1.setmProducto(new Producto(2,"azucar",34));
         System.out.println("Comprobante "+comprobante.getTipo()+"\nFactura n° "+comprobante.getNumero()); 
        //System.out.println(f1.getFecha().getDia()+"-"+f1.getFecha().getMes()+"-"+f1.getFecha().getAnio());
         System.out.println("Cliente: "+f1.getmCliente().getRazonSocial());
         System.out.println(f1.getmProducto().get(0).getDescripcion() + "  $"+f1.getmProducto().get(0).getPrecio());
         System.out.println(f1.getmProducto().get(1).getDescripcion()+ "  $"+f1.getmProducto().get(1).getPrecio());
         f1.setTotal((f1.getmProducto().get(0).getPrecio()+f1.getmProducto().get(1).getPrecio()));
         System.out.println("Total:  $"+f1.getTotal());
         
     }
}
