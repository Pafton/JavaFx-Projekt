package org.example.javafxprojekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloController {
    public ListView<String> lvClientData;
    public Button bPrintBookList;
    private ObservableList<String> personData = FXCollections.observableArrayList();
    public ListView<String> lvBookData;
    private ObservableList<String> bookData = FXCollections.observableArrayList();
    private ObservableList<Book> bookList = FXCollections.observableArrayList();
    public Button bAddData;
    public Button bAddBook;
    public Button bProgramInfo;
    public Button bRent;

    public void printBookList() {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void dialogOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("O programie");
        alert.setHeaderText("Aplikacja: Wypożyczalnia");
        alert.setContentText("Autor: Paweł Trojnar\nWersja:1.0");
        alert.showAndWait();
    }

    public void dialogAddClientData(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientData.fxml"));
        Parent parent = fxmlLoader.load();
        ClientController clientController = fxmlLoader.getController();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wprowadz dane");
        alert.getDialogPane().setContent(parent);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            String adres = clientController.person.toString();
            personData.add(adres);
            lvClientData.setItems(personData);
            lvClientData.refresh();
        }
    }

    public void dialogAddBookData(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookData.fxml"));
        Parent parent = fxmlLoader.load();
        BookController bookController = fxmlLoader.getController();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wprowadz dane");
        alert.getDialogPane().setContent(parent);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Book book = bookController.book;
            bookData.add(book.toString());
            bookList.add(book); // Dodanie nowej książki do listy bookList
            lvBookData.setItems(bookData);
            lvBookData.refresh();
        }
    }


    public void openRentDialog(ActionEvent actionEvent) throws IOException {
        ButtonType zatwierdz = new ButtonType("Zatwierdz", ButtonBar.ButtonData.OK_DONE);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Rent.fxml"));
        Parent parent = fxmlLoader.load();
        RentController rentController = fxmlLoader.getController();
        rentController.initializeChoiceBoxes(personData, bookData, bookList);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().setAll(zatwierdz);
        alert.setTitle("Wypożycz książkę");
        alert.getDialogPane().setContent(parent);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == zatwierdz) {
            rentController.dialogConfirm();
            Book selectedBook = rentController.getSelectedBook();
            if (selectedBook != null) {
                selectedBook.increaseCount(); // Zwiększenie liczby dostępnych egzemplarzy po zwrocie
            }
            lvBookData.refresh();
        }
    }

}