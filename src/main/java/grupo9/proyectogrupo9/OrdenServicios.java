/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo9.proyectogrupo9;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class OrdenServicios {
    private List<Orden> ordenes;
    private List<Servicio> servicios;
    
    public OrdenServicios(){
        ordenes = new ArrayList<>();
        servicios = new ArrayList<>();
    }
    
    public void añadirOrden(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el código del cliente:");
        String codigoCliente = sc.nextLine();
        System.out.println("Ingrese la fecha del servicio (dd/mm/yyyy):");
        String fecha = sc.nextLine();
        System.out.println("Ingrese el tipo de vehículo (1- automóvil, 2 motocicletas, 3- bus):");
        TipoVehiculo tipoVehiculo = TipoVehiculo.values()[sc.nextInt()];
        sc.nextLine();
        System.out.println("Ingrese la placa del vehiculo:");
        String placa = sc.nextLine();
        
        Orden orden = new Orden(codigoCliente, fecha, tipoVehiculo, placa);
    }
    
    public Servicio getServiceByCode(String code) {

    for (Servicio service : servicios) {
        if (service.getCodigo().equals(code)) {
            return service;
        }
    }
    return null;
}

public List<Orden> getOrders() {
    return ordenes;
}

public void setServices(List<Servicio> servicios) {
    this.servicios= servicios;
}
}
