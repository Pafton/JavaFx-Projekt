package org.example.javafxprojekt;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {
    public TextField tfName;
    public TextField tfBookGenre;
    public TextField tfAuthor;
    public TextField tfPublicationDate;
    public TextField tfCount;
    Book book = new Book();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfName.textProperty().bindBidirectional(book.name);
        tfBookGenre.textProperty().bindBidirectional(book.bookGenre);
        tfAuthor.textProperty().bindBidirectional(book.author);
        tfPublicationDate.textProperty().bindBidirectional(book.datePublication);
        tfCount.textProperty().bindBidirectional(book.count);
    }
}
