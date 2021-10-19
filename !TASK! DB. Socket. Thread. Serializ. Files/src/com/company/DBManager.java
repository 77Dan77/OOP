package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connected");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezone=UTC","root","");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addBook(Book book){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `book`(`id`, `title`, `author, `price`) VALUES (NULL, ?,?,?)");
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setLong(3, book.getPrice());

            statement.executeUpdate(); /////  UPDATE, INSERT, DELETE
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Book> selectAllBooks(String aut){
        ArrayList<Book> listFromDB = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `book` WHERE author = ?");
            statement.setString(1, aut);
            ResultSet table =  statement.executeQuery();//// SELECT

            while(table.next()){
                Long id = table.getLong("id");
                String title = table.getString("title");
                String author = table.getString("author");
                Long price = table.getLong("price");


                listFromDB.add(new Book(id, title, author, price));
            }
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return  listFromDB;
    }

    public void deleteBook(Long studentID){
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `book` WHERE id = ?");
            statement.setLong(1, studentID);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
