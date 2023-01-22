/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo9.proyectogrupo9;

/**
 *
 * @author Sebasceb
 */
public class Servicio {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Servicio(String ccodigo, String nombre, float precio){
      this.codigo=codigo;
      this.nombre=nombre;
      this.precio=precio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null &&  obj instanceof Servicio){
            Servicio other = (Servicio) obj;
            return (codigo==other.codigo);
        }
        else
            return false;
    }
}
