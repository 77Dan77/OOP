package com.company;

import java.io.BufferedReader;
import java.io.Serializable;

public class Book implements Serializable {
    private Long id;
    private String title;
    private String author;
    private Long price;

    public Book(Long id, String title, String author, Long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book( String author) {
        this.author = author;
    }


    public Book() {
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + author + " " + price;
    }
}
