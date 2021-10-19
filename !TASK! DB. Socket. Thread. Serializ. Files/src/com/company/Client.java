package com.company;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            Scanner input = new Scanner(System.in);
            Socket socket = new Socket("127.0.0.1", 1300);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


            PackageData packageData = new PackageData();

            while (true) {
                System.out.println("PRESS 1 TO ADD Book");
                System.out.println("PRESS 2 TO LIST Book");
                System.out.println("PRESS 0 TO FINISH");

                int choice = input.nextInt();

                if (choice == 1) {///INSERT DATA
                    System.out.print("Input title: ");
                    String title = input.next();
                    System.out.print("Input author: ");
                    String author = input.next();
                    System.out.print("Input price: ");
                    Long price = input.nextLong();

                    Book book = new Book(null, title, author, price);

                    packageData = new PackageData("ADD_BOOK", book);
                    objectOutputStream.writeObject(packageData);

                } else if (choice == 2) {///SELECT
                    System.out.println("INPUT AUTHOR NAME THAT BOOKS YOU WANT TO LIST: ");
                    packageData.book.setAuthor(input.next());
                    packageData.setOperationType("LIST_BOOK");
                    objectOutputStream.writeObject(packageData);

                    if ((packageData = (PackageData)objectInputStream.readObject()) != null){
                        ArrayList<Book> list = packageData.getBooks();
                        for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                        }
                    }
                }

                  else if (choice == 0) {
                    break;
                }
            }

            System.out.println("ZSDSdSdz");

    } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }}


