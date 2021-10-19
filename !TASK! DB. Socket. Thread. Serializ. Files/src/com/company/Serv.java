package com.company;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serv {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            ServerSocket serverSocket = new ServerSocket(1300);
            System.out.println("...");
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected! \n");
                ClientHandle clientHandle = new ClientHandle(socket);
                clientHandle.start();

            }
        } catch (IOException e) {
                e.printStackTrace();
            }

    }
}