package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int distance = 2000;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Car> cars = null;
        int n = 0;
        try {
            System.out.println("Enter the count of cars: ");
            n = Integer.parseInt(reader.readLine());
            cars = new ArrayList<>();
        for (int i = 0; i < n; i++){
            System.out.println("Enter " + (i+1) + " cars: ");
                cars.add(new Car(reader.readLine(), (int) Double.parseDouble(reader.readLine()), distance));
            System.out.println("");
             }
        } catch (IOException e) {
            e.printStackTrace();
             }

        for (Car c: cars){
            c.start();
        }
        ArrayList<Car>  listCar = new ArrayList<>();
        for (Car c: cars){
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cars.sort(Comparator.comparing(Car::getTime));
        int i = 1;
        for (Car c: cars){
            System.out.println(i + " car is " + c.gtName() + " " + c.getTime());
            i++;
        }

    }
}
