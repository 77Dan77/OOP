package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(1308);
            System.out.println("...");

            Socket socket = serverSocket.accept();
            System.out.println("acepetd");

            Listener listener = new Listener(socket);
            Writer writer = new Writer(socket);

            listener.start();
            writer.start();


        } catch (IOException e) {

        }
    }
}
