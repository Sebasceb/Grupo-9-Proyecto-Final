package grupo9.proyectogrupo9;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MenuInicioController {
    @FXML
    private TextField usuario;
    @FXML
    private TextField clave;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
