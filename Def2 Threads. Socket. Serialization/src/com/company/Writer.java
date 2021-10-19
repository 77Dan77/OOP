package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Writer extends Thread {
Socket socket;

public Writer(){

}

public Writer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());


            while (true) {
                System.out.println("Enter message: ");
                String text = reader.readLine();
                objectOutputStream.writeObject(text);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        //////////////////////////////////////////////////////////////////////////////////////////

}}
