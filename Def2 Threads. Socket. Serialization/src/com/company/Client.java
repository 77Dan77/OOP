package com.company;

import java.io.*;
import java.net.Socket;
import java.security.SecureRandom;

public class Client {
    public static void main(String[] args) {

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket("127.0.0.1", 1308);


            Listener listener = new Listener(socket);
            Writer writer = new Writer(socket);

            listener.start();
            writer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
