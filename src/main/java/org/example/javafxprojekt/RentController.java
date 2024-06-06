package org.example.javafxprojekt;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RentController {
    @FXML
    public ChoiceBox<String> cbChooseClient;
    @FXML
    public ChoiceBox<String> cbChooseBook;
    @FXML
    public Button bConfirm;
    @FXML
    public CheckBox cbRent;
    @FXML
    public CheckBox cbReturn;
    private ObservableList<Book> bookList;

    public void initializeChoiceBoxes(ObservableList<String> clients, ObservableList<String> books, ObservableList<Book> bookList) {
        cbChooseClient.setItems(clients);
        cbChooseBook.setItems(books);
        this.bookList = bookList;

        // Dodajemy nasłuchiwacze do checkboxów, aby tylko jeden mógł być zaznaczony na raz
        cbRent.setOnAction(event -> {
            if (cbRent.isSelected()) {
                cbReturn.setSelected(false);
            }
        });

        cbReturn.setOnAction(event -> {
            if (cbReturn.isSelected()) {
                cbRent.setSelected(false);
            }
        });
    }

    @FXML
    public void dialogConfirm() {
        String selectedClient = cbChooseClient.getValue();
        String selectedBook = cbChooseBook.getValue();

        if (selectedClient != null && selectedBook != null) {
            for (Book book : bookList) {
                if (book.toString().equals(selectedBook)) {
                    if (cbReturn.isSelected()) {
                        System.out.println("cbReturn isSelected: " + cbReturn.isSelected());
                        book.increaseCount();
                    }else if(cbRent.isSelected()){
                        System.out.println("cbRent isSelected: " + cbRent.isSelected());
                        book.decreaseCount();
                    }
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Potwierdzenie");
            alert.setHeaderText("Operacja potwierdzona");
            alert.setContentText("Klient: " + selectedClient + "\nKsiążka: " + selectedBook +
                    (cbRent.isSelected() ? "\nWypożyczenie potwierdzone" : "\nZwrot potwierdzony"));
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd");
            alert.setHeaderText("Brak wyboru");
            alert.setContentText("Proszę wybrać klienta i książkę.");
            alert.showAndWait();
        }
    }


    public Book getSelectedBook() {
        String selectedBook = cbChooseBook.getValue();
        for (Book book : bookList) {
            if (book.toString().equals(selectedBook)) {
                return book;
            }
        }
        return null;
    }
}
