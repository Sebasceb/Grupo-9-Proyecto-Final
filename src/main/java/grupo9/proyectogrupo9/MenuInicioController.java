package grupo9.proyectogrupo9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class MenuInicioController {
    
    @FXML
    private TextField usuario;
    @FXML
    private TextField clave;
    
    
    @FXML
    public void comprobarUsuario(){
        try(BufferedReader br = new BufferedReader(new FileReader("files/Usuarios.txt"))){
            String line;
            int bandera=0;
            while((line = br.readLine()) != null){
                String[] datos = line.split(",");
                if(usuario.getText().equals(datos[0]) && datos[1].equals(clave.getText())){
                    String tipo = datos[3];
                    bandera=1;
                    App.setRoot("Menu"+tipo.toUpperCase().charAt(0)+tipo.substring(1,tipo.length()).toLowerCase());
                } 
            }
            if(bandera==0)
                mostrarAlerta(Alert.AlertType.INFORMATION, "Los datos ingresados son incorrectos. Por favor, verifique y vuelva a ingresar ");
            
        } catch(IOException err){
            System.out.println(err.getMessage());   
        }
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    @FXML
    private void jugarMemoria() throws IOException {
        App.setRoot("JuegoMemoria");
    }
    
    
    
}
