package org.example.javafxprojekt;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    SimpleStringProperty name = new SimpleStringProperty();
    SimpleStringProperty lastName= new SimpleStringProperty();
    SimpleStringProperty street= new SimpleStringProperty();
    SimpleStringProperty townName = new SimpleStringProperty();

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name.get() +
                ", lastName=" + lastName.get() +
                ", street=" + street.get() +
                ", townName=" + townName.get() +
                '}';
    }
}
