package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int CountOfBook = sc.nextInt();
        ArrayList<Books> books = new ArrayList<>();
        ArrayList<Library> libraries = new ArrayList<>();

        int Formula = (CountOfBook/10) * 4;

        for (int i = 0; i < 2; i++){
            System.out.println("Enter library's name and city: ");
            libraries.add(new Library(sc.next(),sc.next()));

            for (int j = 0; j < CountOfBook; j++){
                System.out.println("Name, author, isbn, price of book");
                books.add(new Books(sc.next(),sc.next(),sc.nextInt(),sc.nextInt()));
            }

            for (int j = 0; j < Formula; j++) {
                libraries.get(i).addBook(books.get(j));
            }
            i++;
            for (int j = Formula; j < CountOfBook; j++){
                libraries.get(i).addBook(books.get(j));
            }
        }

        System.out.println(TotAmount(libraries));
        for (int i = 0; i < libraries.size(); i++){
        libraries.get(i).priceSum();
            for (int j = 0; j < libraries.get(i).getBooks().size(); j++){
              libraries.get(i).getBooks().get(j).getPrice();
        }
        i++;
             for (int j = 0; j < libraries.get(i).getBooks().size(); j++){
                libraries.get(i).getBooks().get(j).getPrice();
        }
    }

    }


    public static int TotAmount(ArrayList<Library> libraries){
        int tot = 0;
        for (int i = 0; i < libraries.size(); i++){
            tot += libraries.get(i).sizee();
        }
        return tot;
    }
}
