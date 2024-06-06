package org.example.javafxprojekt;

import javafx.beans.property.SimpleStringProperty;

public class Book {
    SimpleStringProperty name = new SimpleStringProperty();
    SimpleStringProperty bookGenre= new SimpleStringProperty();
    SimpleStringProperty author= new SimpleStringProperty();
    SimpleStringProperty datePublication= new SimpleStringProperty();
    SimpleStringProperty count = new SimpleStringProperty();

    public String getCount() {
        return count.get();
    }

    public void setCount(String count) {
        this.count.set(count);
    }

    public void decreaseCount() {
        int currentCount = Integer.parseInt(count.get());
        if (currentCount > 0) {
            count.set(String.valueOf(currentCount - 1));
        }
    }
    public void increaseCount() {
        int currentCount = Integer.parseInt(count.get());
        if (currentCount > 0) {
            count.set(String.valueOf(currentCount + 1));
        }
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String  getName() {
        return name.get();
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name.get() + ", bookGenre=" + bookGenre.get() +
                ", author=" + author.get() + ", datePublication=" + datePublication.get() +
                ", count=" + count.get() + "}";
    }


}
