/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo9.proyectogrupo9;

/**
 *
 * @author Sebasceb
 */
public class Proveedor {
    public String codigo;
    public String nombre;
    public String direccion;
    public String telefono;

    public Proveedor(String c, String n, String d, String t){
      this.codigo=c;
      this.nombre=n;
      this.direccion=d;
      this.telefono=t;
    }
    public String getCodigo(){
      return codigo;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", codigo, nombre, direccion, telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
