package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandle extends Thread{
    private Socket socket;
    private int id;


    @Override
    public void run() {


        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            Person person = null;
            while ((person = (Person)inputStream.readObject()) != null){
                System.out.println(id + " " + person.toString());
                if (person.getMessage().toLowerCase().contains("hello")){
                    person.setMessage("\nHello from server!");
                    outputStream.writeObject(person);
                }

            }

            inputStream.close();
            outputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public ClientHandle(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    public int getIid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
