package com.company;

import java.util.ArrayList;

public class Library {
    private String name;
    private String city;
    private ArrayList<Books> books = new ArrayList<Books>();

    public Books getBook(int books){
        return this.books.get(books);
    }

    public void addBook(Books books) {
        this.books.add(books);
    }

    public int sizee () {
        return books.size();
    }

    public int priceSum () {
        int sum = 0;
        for (int i = 0; i < books.size(); i++){
            sum += books.get(i).getPrice();
        }
        return sum;
    }



    public Library(String name, String city) {
        this.name = name;
        this.city = city;
    }

        public Library(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Books> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
    }
}
