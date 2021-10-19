package com.company;

import javax.naming.ldap.ExtendedRequest;
import javax.swing.*;
import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<GoodItem> goodItems = new ArrayList<>();
        ArrayList<BuyHistory> buyHistories = new ArrayList<>();
        goodItems.add(new GoodItem("Iphone12", 500000));
        goodItems.add(new GoodItem("S11", 499990));
        goodItems.add(new GoodItem("Xiaomi10", 399000));
        goodItems.add(new GoodItem("Lenovo", 205000));
        goodItems.add(new GoodItem("Sony", 450000));
        saveGoodItems(goodItems);


        while (true){
            Date date = new Date();
            System.out.println("Press[1] to buy, Press[2] to add good," +
                    " Press[3] to buy delete good, Press[4] to add history," +
                    " Press[5] to list items, Press[6] to show history, Press[0] to exit: ");

            int button = 0;
            try {
                button = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (button == 0){
                System.exit(1);
            }

            else if (button == 1){
                System.out.println(getGoodItemList());
                System.out.println("Write index of good that you want to buy");
                try {
                    int ind = Integer.parseInt(reader.readLine());
                    buyHistories.add(new BuyHistory(goodItems.get(ind).getName(),
                            goodItems.get(ind).getPrice(), date));

//                    buyingGood(goodItems,ind);
                    saveBuyHistories(buyHistories);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            else if (button == 2){
                System.out.println("Adding of good.. ");
                goodItems = addGoodItems(goodItems);
                saveGoodItems(goodItems);
            }

            else if (button == 3){
                System.out.println("Deleting of good.. ");
                deleteGoodItems(goodItems);
                saveGoodItems(goodItems);
            }

            else if (button == 4){
                System.out.println("Adding og history.. ");
                addHistory(buyHistories);
                saveBuyHistories(buyHistories);
            }

            else if (button == 5){
                System.out.println("List of items: ");
                System.out.println(getGoodItemList());
            }

            else if (button == 6){
                System.out.println("History: ");
                System.out.println(getBuyHistoryList());
            }


            System.out.println(" ");
            System.out.println(" ");
        }


    }

    public static void buyingGood(ArrayList<GoodItem> goodItems, int ind){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt", true))){
            writer.write(goodItems.get(ind).toString() + " \n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<GoodItem> addGoodItems(ArrayList<GoodItem> goodItems){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write name and price of good: ");
        try {
            goodItems.add(new GoodItem(reader.readLine(), Integer.parseInt(reader.readLine())));

        } catch (IOException e) {
            System.out.println("Ne dobavilos'((");
            e.printStackTrace();
        }
        return goodItems;
    }

    public static void deleteGoodItems(ArrayList<GoodItem> goodItems){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write index of element that you want to delete: ");

        try {
            int index = Integer.parseInt(reader.readLine());
           goodItems.remove(index);
        } catch (IOException e) {
            System.out.println("Ne udalilos'((");
            e.printStackTrace();
        }
    }

    public static void addHistory(ArrayList<BuyHistory> buyHistories){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write name and price: ");

        try {
           buyHistories.add(new BuyHistory(reader.readLine(), Integer.parseInt(reader.readLine())));
        } catch (IOException e) {
            System.out.println("Ne dobavilos'((");
            e.printStackTrace();
        }
    }



    public static ArrayList<GoodItem> getGoodItemList() {
        ArrayList<GoodItem> goodItems = null;
        BufferedReader reader = null;

        try {
            goodItems = new ArrayList<>();
            reader = new BufferedReader(new FileReader("goods.txt"));
            String text = "";

            while ((text = reader.readLine())!=null){
                String arr[] = text.split(" ");
                goodItems.add(new GoodItem(arr[0], Integer.parseInt(arr[1])));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return goodItems;
    }

    public static void saveGoodItems(ArrayList<GoodItem> goodItems) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("goods.txt"))){
            for (GoodItem g: goodItems){
                writer.write(g.toString() + " \n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<BuyHistory> getBuyHistoryList(){
        BufferedReader reader = null;
        ArrayList<BuyHistory> buyHistories = null;
        try{
            reader = new BufferedReader(new FileReader("history.txt"));
            buyHistories = new ArrayList<>();
            String text = " ";
            while ((text = reader.readLine())!=null) {
                  String arr[] = text.split("-");
//                Date date = new Date(arr[2]);
                buyHistories.add(new BuyHistory(arr[0], Integer.parseInt(arr[1]), date));

            }

        }catch (Exception e){
            System.out.println("Не полцчилось братан( ");
            e.printStackTrace();
        }

        return buyHistories;
    }

   public static void saveBuyHistories(ArrayList<BuyHistory> buyHistory){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt"))){
            for (BuyHistory b: buyHistory){
                writer.write(b.toString() + " \n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

   }



}
