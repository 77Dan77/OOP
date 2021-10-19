package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Good> tablets = new ArrayList<>();
        ArrayList<Good> computers = new ArrayList<>();
        ArrayList<Good> smartPhones = new ArrayList<>();
        ArrayList<Good> devices = new ArrayList<>();



        System.out.println("Wrire count of Tablets: ");
        int CountOfTablet = sc.nextInt();
        for (int i = 0; i < CountOfTablet; i++){
            System.out.println("Enter double price, String model, int count, String type, String cpu, int ram, double weight, boolean touch");
            tablets.add(new Tablet(sc.nextDouble(), sc.next(), sc.nextInt(), sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextBoolean()));
        }
        System.out.println("Wrire count of Computers: ");
        int CountOfComp = sc.nextInt();
        for (int i = 0; i < CountOfComp; i++){
            System.out.println("double price, String model, int count, String type, String cpu, int ram, boolean ssd, int memory");
            computers.add(new Computer(sc.nextDouble(), sc.next(), sc.nextInt(), sc.next(),sc.next(),sc.nextInt(),sc.nextBoolean(), sc.nextInt()));
        }
        System.out.println("Wrire count of Smartphones: ");
        int CountOfSmartPh = sc.nextInt();
        for (int i = 0; i < CountOfSmartPh; i++){
            System.out.println("double price, String model, int count, String type, String cpu, int ram, boolean ssd, int memory");
            smartPhones.add(new SmartPhone(sc.nextDouble(), sc.next(), sc.nextInt(), sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt()));
        }


        int Allgoods = CountOfComp+CountOfSmartPh+CountOfTablet;

        for (int i = 0; i < CountOfTablet; i++){
            devices.add(tablets.get(i));
        }
        for (int i = 0; i < CountOfComp; i++){
            devices.add(computers.get(i));
        }
        for (int i = 0; i < CountOfSmartPh; i++){
            devices.add(smartPhones.get(i));
        }

    ArrayList<Double> soldDev = new ArrayList<>();

        boolean infinity = true;
        while (infinity){
            System.out.println("Welcome! You are Admin or buyer?(PRESS [1] - Admin, PRESS [2] - Buyer, PRESS[0] TO EXIT)");
            int user = sc.nextInt();

            if (user == 2) {
                System.out.println("Hello Buyer!\n");
                System.out.println("PRESS [1] TO VIEW ALL GOODS");
                System.out.println("PRESS [2] TO BUY GOOD");
                System.out.println("PRESS [3] TO SHOW PARTICULAR GOODS (FILTER)");
                System.out.println("PRESS [4] TO SORT GOODS BY PRICE");
                int choise = sc.nextInt();

                int t = 0;
                if (choise == 1) {
                    System.out.println("Details of each good: ");
                    for(int i = 0; i < CountOfTablet; i++){
                        System.out.print(t + "  ");
                        System.out.println(tablets.get(i).showDetails());
                        t++;
                    }

                    for (int i = 0; i < CountOfComp; i++){
                        System.out.print(t + "  ");
                        System.out.println(computers.get(i).showDetails());
                        t++;
                    }

                    for (int i = 0; i < CountOfSmartPh; i++){
                        System.out.print(t + "  ");
                        System.out.println((computers.get(i).showDetails()));
                        t++;
                    }
                    continue;
                }
                t = 0;
                if (choise == 2){
                    System.out.println("Which good you want to buy? (Enter index )");
                    int indexOfBuy = sc.nextInt();
                    if ((indexOfBuy < Allgoods) && (indexOfBuy > (-1))){
                        devices.get(indexOfBuy).setCount(devices.get(indexOfBuy).getCount()-1);
                        soldDev.add(devices.get(indexOfBuy).getPrice());
                        continue;

                    }
                    else {
                        System.out.println("Not exsist good with this index!");
                    }
                }
                t = 0;
                if (choise == 3){
                    System.out.println("Choose which type of devise you want to see ([1] - Tablets, [2] - Computers, [3] - SmartPhones)");
                    int typeOfDev = sc.nextInt();
                    if (typeOfDev == 1){
                        for (int i = 0; i < CountOfTablet; i++){
                            System.out.println(t + ":  " + tablets.get(i).showDetails());
                            t++;
                        }
                    }

                    else if (typeOfDev == 2){
                        for (int i = 0; i < CountOfComp; i++){
                            System.out.println(t + ":  " + computers.get(i).showDetails());
                            t++;
                        }
                    }

                    else if (typeOfDev == 3){
                        for (int i = 0; i < CountOfSmartPh; i++){
                            System.out.println(t + ":  " + smartPhones.get(i).showDetails());
                            t++;
                        }
                    }
                }

                if (choise == 4){
                    System.out.println("Sorting by Price....");

                    for (int i = 0; i < devices.size(); i++){
                        for (int j = 0; j < devices.size()-1; j++){
                            if (devices.get(j).getPrice() > devices.get(j+1).getPrice()){
//                                getPricedouble temp = devices.get(j).getPrice();
//                                devices.get(j).getPrice() = devices.get(j+1).getPrice();
//                                devices.get(j+1).getPrice() = temp;
                                Collections.swap(devices, j, j+1);
                            }

                        }
                    }

                    for (int i = 0; i < devices.size(); i++){
                        System.out.println(devices.get(i).showDetails());
                    }


                }

            }



            else if (user == 1) {
                System.out.println("Hello Admin!\n");
                System.out.println("PRESS [1] TO Add product");
                System.out.println("PRESS [2] TO SUPPLEMENT");
                System.out.println("PRESS [3] TO DELETE GOOD");
                System.out.println("PRESS [4] TO SHOW TOTAL INCOME");
                int choise = sc.nextInt();


                if (choise == 1){
                    System.out.println("Please write type of devise([1] - Tablets, [2] - Computers, [3] - SmartPhones): ");
                    int type = sc.nextInt();
                    if (type == 1){
                        System.out.println("Enter double price, String model, int count, String type, String cpu, int ram, double weight, boolean touch");
                        devices.add(new Tablet(sc.nextDouble(), sc.next(), sc.nextInt(), sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextBoolean()));
                    }
                    if (type == 2){
                        System.out.println("Enter double price, String model, int count, String type, String cpu, int ram, double weight, boolean touch");
                        devices.add(new Computer(sc.nextDouble(), sc.next(), sc.nextInt(), sc.next(),sc.next(),sc.nextInt(),sc.nextBoolean(), sc.nextInt()));
                    }
                    if (type == 3){
                        System.out.println("Enter double price, String model, int count, String type, String cpu, int ram, double weight, boolean touch");
                        devices.add(new SmartPhone(sc.nextDouble(), sc.next(), sc.nextInt(), sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt()));
                    }


                }


                if (choise == 2){
                    System.out.println("Write of which product (index) you want to increase the count: " );
                    int supp = sc.nextInt();
                    System.out.println("How many items you want to add");
                    int items = sc.nextInt();
                    devices.get(supp).setCount(devices.get(supp).getCount()+items);
                }


                if (choise == 3){
                    System.out.println("Write index of good that you want to delete");
                    int delete = sc.nextInt();
                    if ((delete < Allgoods) && (delete > (-1))) {
                        devices.remove(delete);
                        devices.get(delete).setCount(devices.get(delete).getCount()-1);
                    }
                    else {
                        System.out.println("Out of range! ");
                    }
                }

                if (choise == 4){
                    System.out.println("Total inccome is: ");
                    double income = 0;
                    for (int i = 0; i < soldDev.size(); i++){
                        income += soldDev.get(i);
                    }
                    System.out.println(income);

                }


            }

                else if (user == 0) System.exit(0);

                else {
                System.out.println("Incorrect input! please try again");
                continue;
            }

        }




    }
}
