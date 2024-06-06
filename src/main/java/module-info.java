module org.example.javafxprojekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxprojekt to javafx.fxml;
    exports org.example.javafxprojekt;
}