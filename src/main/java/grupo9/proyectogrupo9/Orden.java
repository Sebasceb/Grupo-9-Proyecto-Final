/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo9.proyectogrupo9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebasceb
 */
public class Orden {
    private String placa;
    private String fecha;  //  dd/mm/yyyy
    private TipoVehiculo tipo;
    private String codigoCliente;
    private final ArrayList<Servicio> listaServicios;
    private double total;

    public Orden(String p, String f, TipoVehiculo t, String c) {
        this.placa = p;
        this.fecha = f;
        this.tipo = t;
        this.codigoCliente = c;
        listaServicios = new ArrayList<>();
        total = 0;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getMes() {
        return this.fecha.substring(3, 5);
    }

    public String getFecha() {
        return fecha;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public double getTotal() {
        return total;
    }

    public void agregarServicio(Servicio servicio) {
        listaServicios.add(servicio);
        total += servicio.getPrecio();
    }

    public List<Servicio> getServiciosDeOrden() {
        return listaServicios;
    }


}
