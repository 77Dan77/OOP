package com.company;

import java.io.*;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket("127.0.0.1", 1300);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            while (true){
                String name = reader.readLine();
                String text = reader.readLine();
                Person person = new Person(name, text);
                objectOutputStream.writeObject(person);
                if ((person = (Person)objectInputStream.readObject())!=null){
                    System.out.println(person.getMessage());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
