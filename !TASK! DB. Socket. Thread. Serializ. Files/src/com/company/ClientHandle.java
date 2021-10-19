package com.company;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientHandle extends Thread{
    private Socket socket;


    @Override
    public void run() {
    DBManager manager = new DBManager();
    manager.connect();

        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData packageData = null;
            while ((packageData = (PackageData) inputStream.readObject()) != null){

                if(packageData.getOperationType().equals("ADD_BOOK")){
                    manager.addBook(packageData.getBook());
                }

                else if(packageData.getOperationType().equals("LIST_BOOK")){
                     packageData.setBooks(manager.selectAllBooks(packageData.getBook().getAuthor()));
                     outputStream.writeObject(packageData);

                }

            }

            inputStream.close();
            outputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    public ClientHandle(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
