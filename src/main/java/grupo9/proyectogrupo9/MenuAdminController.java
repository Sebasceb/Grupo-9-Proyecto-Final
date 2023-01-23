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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.DoubleStringConverter;

/**
 * FXML Controller class
 *
 * @author sebas
 */
public class MenuAdminController implements Initializable {
    
    @FXML
    private BorderPane contenedorPrincipal;
    @FXML
    private TableView TablaDatos;
    @FXML
    private VBox VboxEdicion;
    @FXML
    private Text Texto1;
    @FXML
    private Text Texto2;
    @FXML
    private Text Texto3;
    @FXML
    private Text Texto4;
    @FXML
    private Text Texto5;
    @FXML
    private TextField Input1;
    @FXML
    private TextField Input2;
    @FXML
    private TextField Input3;
    @FXML
    private TextField Input4;
    @FXML
    private TextField Input5;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void regresarInicio() throws IOException {
        App.setRoot("MenuInicio");
    }


    public void administrarCliente() {
        
        Texto1.setText("Cédula");
        Texto2.setText("Nombre");
        Texto3.setText("Dirección");
        Texto4.setVisible(true);
        Texto4.setText("Teléfono");
        Input4.setVisible(true);
        Texto5.setVisible(true);
        Texto5.setText("Tipo");
        Input5.setVisible(true);
        VboxEdicion.setVisible(true);
        
        
        TablaDatos.getItems().clear();
        TablaDatos.getColumns().clear();
        TablaDatos.setEditable(true);
        TablaDatos.setVisible(true);
        
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
        
        TablaDatos.getColumns().addAll(columnCodigo,columnNombre,columnDireccion,columnTelefono,columnTipo);
        TablaDatos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        for(Cliente c: App.getDataBase().listaClientes){
            TablaDatos.getItems().add(c);
        }
        
        contenedorPrincipal.setCenter(TablaDatos);
        
    }

    public void administrarProveedor() {
        Texto1.setText("Cédula");
        Texto2.setText("Nombre");
        Texto3.setText("Dirección");
        Texto4.setVisible(true);
        Input4.setVisible(true);
        Texto4.setText("Teléfono");
        Texto5.setVisible(false);
        Input5.setVisible(false);
        VboxEdicion.setVisible(true);
        
        TablaDatos.getItems().clear();
        TablaDatos.getColumns().clear();
        TablaDatos.setEditable(true);
        TablaDatos.setVisible(true);
        
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
        
        
        
        TablaDatos.getColumns().addAll(columnCodigo,columnNombre,columnDireccion,columnTelefono);
        TablaDatos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        for(Proveedor p: App.getDataBase().listaProveedores){
            TablaDatos.getItems().add(p);
        }
        
        contenedorPrincipal.setCenter(TablaDatos);

    }

    public void administrarServicios() {
        Texto1.setText("Código");
        Texto2.setText("Nombre");
        Texto3.setText("Precio");
        Texto4.setVisible(false);
        Input4.setVisible(false);
        Texto5.setVisible(false);
        Input5.setVisible(false);
        VboxEdicion.setVisible(true);
        TablaDatos.getItems().clear();
        TablaDatos.getColumns().clear();
        TablaDatos.setEditable(true);
        TablaDatos.setVisible(true);
        
        TableColumn columnCodigo = new TableColumn<Servicio, String>("Codigo");
        columnCodigo.setCellValueFactory(new PropertyValueFactory<Servicio, String>("codigo"));
        columnCodigo.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        TableColumn columnNombre= new TableColumn<Servicio, String>("Nombre");
        columnNombre.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombre"));
        columnNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
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
        
        
        
        
        
        TablaDatos.getColumns().addAll(columnCodigo,columnNombre,columnPrecio);
        TablaDatos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        for(Servicio s: App.getDataBase().listaServicios){
            TablaDatos.getItems().add(s);
        }
        
        contenedorPrincipal.setCenter(TablaDatos);
    }
    @FXML
    private void agregar(){
        if(Texto4.isVisible()&&Texto5.isVisible()){
            String c= Input1.getText();
            String n= Input2.getText();
            String d= Input3.getText();
            String tele= Input4.getText();
            TipoCliente tipo= TipoCliente.valueOf(Input5.getText());
            App.getDataBase().agregarCliente(new Cliente(c,n,d,tele,tipo));
            administrarCliente();
        }else if(Texto4.isVisible()&& !Texto5.isVisible()){
            String c= Input1.getText();
            String n= Input2.getText();
            String d= Input3.getText();
            String tele= Input4.getText();
            App.getDataBase().agregarProveedor(new Proveedor(c,n,d,tele));
            administrarProveedor();
        }else{
            String c= Input1.getText();
            String n= Input2.getText();
            Double p= Double.valueOf(Input3.getText());
            App.getDataBase().agregarServicio(new Servicio(c,n,p));
            administrarServicios();
        }
        Input1.clear();
        Input2.clear();
        Input3.clear();
        Input4.clear();
        Input5.clear();
    }
    @FXML
    private void editar(){
        if(Texto4.isVisible()&&Texto5.isVisible()){
            App.getDataBase().accederClientes().clear();
            for (Object o: TablaDatos.getItems()){
                Cliente c= (Cliente) o;
                App.getDataBase().agregarCliente(c);
            }
        }else if(Texto4.isVisible()&& !Texto5.isVisible()){
            App.getDataBase().accederProveedores().clear();
            for (Object o: TablaDatos.getItems()){
                Proveedor p=(Proveedor) o;
                App.getDataBase().agregarProveedor(p);
            }
        }else{
            App.getDataBase().accederServicios().clear();
            for (Object o: TablaDatos.getItems()){
                Servicio s=(Servicio) o;
                App.getDataBase().agregarServicio(s);
            }
        }
    }
    @FXML
    private void delete(){
        int row=TablaDatos.getSelectionModel().getSelectedIndex();
        if(row>=0)
            TablaDatos.getItems().remove(row);
    }
    
}
