package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener extends Thread{
    Socket socket;

    public Listener(Socket socket) {
        this.socket = socket;
    }

    public Listener(){

    }

    @Override
    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());


                while (!socket.isClosed()) {
                    String text = (String) objectInputStream.readObject();
                    System.out.println("Noname: " + text);
                }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Che to ne to");
        }


    }

}
