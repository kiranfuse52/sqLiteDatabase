package com.example.sqlitedatabase.Model;

public class bookModel {
    long id;
    String Book_name,Book_publisher;

    public bookModel(long id, String book_name, String book_publisher) {
        this.id = id;
        this.Book_name = book_name;
        this.Book_publisher = book_publisher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBook_name() {
        return Book_name;
    }

    public void setBook_name(String book_name) {
        Book_name = book_name;
    }

    public String getBook_publisher() {
        return Book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        Book_publisher = book_publisher;
    }
}
