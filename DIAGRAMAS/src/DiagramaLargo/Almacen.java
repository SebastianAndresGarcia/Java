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
public class Almacen {

    private int IDmaterial_almacen;
    private String nombreMaterialAlmacen;
    private String TipoEmbarque;
    private String TipoMaterial;
    private Empleado empleado;

    public Almacen(int IDmaterial_almacen, String nombreMaterialAlmacen, String TipoEmbarque, String TipoMaterial, Empleado empleado) {
        this.IDmaterial_almacen = IDmaterial_almacen;
        this.nombreMaterialAlmacen = nombreMaterialAlmacen;
        this.TipoEmbarque = TipoEmbarque;
        this.TipoMaterial = TipoMaterial;
        this.empleado = empleado;
    }

    public int getIDmaterial_almacen() {
        return IDmaterial_almacen;
    }

    public void setIDmaterial_almacen(int IDmaterial_almacen) {
        this.IDmaterial_almacen = IDmaterial_almacen;
    }

    public String getNombreMaterialAlmacen() {
        return nombreMaterialAlmacen;
    }

    public void setNombreMaterialAlmacen(String nombreMaterialAlmacen) {
        this.nombreMaterialAlmacen = nombreMaterialAlmacen;
    }

    public String getTipoEmbarque() {
        return TipoEmbarque;
    }

    public void setTipoEmbarque(String TipoEmbarque) {
        this.TipoEmbarque = TipoEmbarque;
    }

    public String getTipoMaterial() {
        return TipoMaterial;
    }

    public void setTipoMaterial(String TipoMaterial) {
        this.TipoMaterial = TipoMaterial;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void consulta() {

    }

    public void actualiza() {

    }
}
