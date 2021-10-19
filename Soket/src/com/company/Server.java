package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int id = 0;
        try {
            ServerSocket serverSocket = new ServerSocket(1300);
            System.out.println("...");
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected! \n");
                id++;
                ClientHandle clientHandle = new ClientHandle(socket,id);
                clientHandle.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
