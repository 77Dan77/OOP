package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList<Book> books;
    Book book;



    public PackageData(String operationType, ArrayList<Book> books, Book book) {
        this.operationType = operationType;
        this.books = books;
    }

    public PackageData(String operationType, Book book) {
        this.operationType = operationType;
        this.book = book;
    }

    public PackageData(String operationType, ArrayList<Book> books) {
        this.operationType = operationType;
        this.books = books;
    }


    public PackageData() {
    }

    public String getOperationTypeB() {
        return operationType + this.book.getAuthor();
    }

    public String getOperationType() {
        return operationType;
    }


    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }



    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
