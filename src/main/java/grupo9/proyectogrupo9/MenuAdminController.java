/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo9.proyectogrupo9;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.DoubleStringConverter;

/**
 * FXML Controller class
 *
 * @author sebas
 */
public class MenuAdminController implements Initializable {
    
    @FXML
    private BorderPane contenedorPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void regresarInicio() throws IOException {
        App.setRoot("MenuInicio");
    }


    public void administrarCliente() {
        TableView table = new TableView<Cliente>();
        table.setEditable(true);
        
        TableColumn columnCodigo = new TableColumn<Cliente, String>("Cédula");
        columnCodigo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codigo"));
        columnCodigo.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        TableColumn columnNombre= new TableColumn<Cliente, String>("Nombre");
        columnNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        columnNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        columnNombre.setOnEditCommit(new EventHandler<CellEditEvent<Cliente, String>>(){
            @Override
            public void handle(CellEditEvent<Cliente, String> event){
                Cliente cliente = event.getRowValue();
                cliente.setNombre(event.getNewValue());
            } 
        });
        
        TableColumn columnDireccion= new TableColumn<Cliente, String>("Dirección");
        columnDireccion.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));
        columnDireccion.setCellFactory(TextFieldTableCell.forTableColumn());
        columnDireccion.setOnEditCommit(new EventHandler<CellEditEvent<Cliente, String>>(){
            @Override
            public void handle(CellEditEvent<Cliente, String> event){
                Cliente cliente = event.getRowValue();
                cliente.setDireccion(event.getNewValue());
            }
        });
        
        TableColumn columnTelefono = new TableColumn<Cliente, String>("Teléfono");
        columnTelefono.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        columnTelefono.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTelefono.setOnEditCommit(new EventHandler<CellEditEvent<Cliente, String>>(){
            @Override
            public void handle(CellEditEvent<Cliente, String> event){
                Cliente cliente = event.getRowValue();
                cliente.setTelefono(event.getNewValue());
            }  
        });
        
        TableColumn columnTipo = new TableColumn<Cliente, String>("Tipo");
        columnTipo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("tipo"));
        columnTipo.setCellFactory(TextFieldTableCell.forTableColumn(new EnumConverter()));
        columnTipo.setOnEditCommit(new EventHandler<CellEditEvent<Cliente, TipoCliente>>(){
            @Override
            public void handle(CellEditEvent<Cliente, TipoCliente> event) {
                Cliente cliente = event.getRowValue();
                cliente.setTipo(event.getNewValue());
            }   
        });
        
        table.getColumns().addAll(columnCodigo,columnNombre,columnDireccion,columnTelefono,columnTipo);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        for(Cliente c: App.getDataBase().listaClientes){
            table.getItems().add(c);
        }
        
        contenedorPrincipal.setCenter(table);
        
    }

    public void administrarProveedor() {
        TableView table = new TableView<Cliente>();
        table.setEditable(true);
        
        TableColumn columnCodigo = new TableColumn<Proveedor, String>("Cédula");
        columnCodigo.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("codigo"));
        columnCodigo.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        TableColumn columnNombre= new TableColumn<Proveedor, String>("Nombre");
        columnNombre.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));
        columnNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        columnNombre.setOnEditCommit(new EventHandler<CellEditEvent<Proveedor, String>>(){
            @Override
            public void handle(CellEditEvent<Proveedor, String> event){
                Proveedor cliente = event.getRowValue();
                cliente.setNombre(event.getNewValue());
            }
            
        });
        
        TableColumn columnDireccion= new TableColumn<Proveedor, String>("Dirección");
        columnDireccion.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("direccion"));
        columnDireccion.setCellFactory(TextFieldTableCell.forTableColumn());
        columnDireccion.setOnEditCommit(new EventHandler<CellEditEvent<Proveedor, String>>(){
            @Override
            public void handle(CellEditEvent<Proveedor, String> event){
                Proveedor cliente = event.getRowValue();
                cliente.setDireccion(event.getNewValue());
            }
            
        });
        
        TableColumn columnTelefono = new TableColumn<Proveedor, String>("Teléfono");
        columnTelefono.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("telefono"));
        columnTelefono.setCellFactory(TextFieldTableCell.forTableColumn());
        columnTelefono.setOnEditCommit(new EventHandler<CellEditEvent<Proveedor, String>>(){
            @Override
            public void handle(CellEditEvent<Proveedor, String> event){
                Proveedor cliente = event.getRowValue();
                cliente.setTelefono(event.getNewValue());
            }
            
        });
        
        
        
        table.getColumns().addAll(columnCodigo,columnNombre,columnDireccion,columnTelefono);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        for(Proveedor p: App.getDataBase().listaProveedores){
            table.getItems().add(p);
        }
        
        contenedorPrincipal.setCenter(table);

    }

    public void administrarServicios() {
        TableView table = new TableView<Cliente>();
        table.setEditable(true);
        
        TableColumn columnCodigo = new TableColumn<Servicio, String>("Codigo");
        columnCodigo.setCellValueFactory(new PropertyValueFactory<Servicio, String>("codigo"));
        columnCodigo.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        TableColumn columnNombre= new TableColumn<Servicio, String>("Nombre");
        columnNombre.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombre"));
        columnNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        columnNombre.setOnEditCommit(new EventHandler<CellEditEvent<Servicio, String>>(){
            @Override
            public void handle(CellEditEvent<Servicio, String> event){
                Servicio cliente = event.getRowValue();
                cliente.setNombre(event.getNewValue());
            }
        });
        
        TableColumn columnPrecio= new TableColumn<Servicio, Double>("Precio");
        columnPrecio.setCellValueFactory(new PropertyValueFactory<Servicio, Double>("precio"));
        columnPrecio.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        columnPrecio.setOnEditCommit(new EventHandler<CellEditEvent<Servicio, Double>>(){
            @Override
            public void handle(CellEditEvent<Servicio, Double> event){
                Servicio cliente = event.getRowValue();
                cliente.setPrecio(event.getNewValue());
            }
        });
        
        
        
        
        
        table.getColumns().addAll(columnCodigo,columnNombre,columnPrecio);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        for(Servicio s: App.getDataBase().listaServicios){
            table.getItems().add(s);
        }
        
        contenedorPrincipal.setCenter(table);
    }
    
}
