package grupo9.proyectogrupo9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuInicioController {
    
    private static Scene scene;
    private Stage stage;
    
    @FXML
    private TextField usuario;
    @FXML
    private TextField clave;
    @FXML
    private Button btnIniciar;

    private void btnIniciar() throws IOException {
        //App.setRoot("secondary");
        
    }

    @FXML
    private void IniciarSesion(ActionEvent event) throws IOException{
        String menu = comprobarUsuario();
        scene = new Scene(loadFXML(menu), 640, 480);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        this.stage.close();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
  
    public String comprobarUsuario(){
        try(BufferedReader br = new BufferedReader(new FileReader("Grupo-9-Proyecto-Final/Usuarios.txt"))){
            String line;
            while((line = br.readLine()) != null){
                String[] datos = line.split(",");
                if(!usuario.getText().equals(datos[0]) || !datos[1].equals(clave.getText())){
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Los datos ingresados son incorrectos. Por favor, verifique y vuelva a ingresar ");
                    
                    
                } else {
                    String tipo = datos[3];
                    return "Menu"+tipo.toUpperCase().charAt(0)+tipo.substring(1,tipo.length()).toLowerCase();
                }   
            }
            
        } catch(IOException err){
            System.out.println(err.getMessage());   
        }
        return null;
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    
    
    
}
