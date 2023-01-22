module grupo9.proyectogrupo9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens grupo9.proyectogrupo9 to javafx.fxml;
    exports grupo9.proyectogrupo9;
}
