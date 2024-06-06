package org.example.javafxprojekt;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public TextField tfName;
    public TextField tfLastName;
    public TextField tfStreetName;
    public TextField tfTownName;
    Person person = new Person();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfName.textProperty().bindBidirectional(person.name);
        tfLastName.textProperty().bindBidirectional(person.lastName);
        tfStreetName.textProperty().bindBidirectional(person.street);
        tfTownName.textProperty().bindBidirectional(person.townName);
    }
}
