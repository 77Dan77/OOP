package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Warehouse wh = new Warehouse(0,0);
        Courier courier = new Courier(100, wh);
        Picker picker = new Picker(80, wh);

        boolean check1 = true;
        boolean check2 = true;

        while(check1 || check2) {

                picker.doWork();
           

            if (wh.getCountOrder() == 1500) {
                picker.bonus();
                check1 = false;
            }


                courier.doWork();


            if(wh.getBalance() == 1000000){
                courier.bonus();
                check2 = false;
            }
        }

        System.out.println("Count order: " + wh.getCountOrder() + "\nBalance: " + wh.getBalance() + "\nCourier salary: " + courier.getSalary() + "\nPicker salary: " + picker.getSalary());

            Warehouse wh2 = new Warehouse(0, 0);
            Courier courier2 = new Courier(100, wh2);
            Picker picker2 = new Picker(80, wh2);

            courier2.doWork();
            picker2.doWork();

        System.out.println("_________________________________________________");
        System.out.println("After working of 2nd workers: ");
        System.out.println("Count order: " + wh.getCountOrder() + "\nBalance: " + wh.getBalance() + "\nCourier salary: " + courier.getSalary() + "\nPicker salary: " + picker.getSalary());


}}
