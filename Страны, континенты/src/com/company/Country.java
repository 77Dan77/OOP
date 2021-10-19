package com.company;

import java.util.Arrays;

public class Country {

    private String name;
    public ResortPlace resortPlaces[];
    private int resortCount;

    public Country(){

    }

    public Country(String name, int resortCount, ResortPlace[] resortPlaces) {
        this.name = name;
        this.resortCount = resortCount;
        this.resortPlaces = resortPlaces;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getResortCount() {
        return resortCount;
    }

    public void setResortCount(int resortCount) {
        this.resortCount = resortCount;
    }

    public void printAllResorts(){

    }

    @Override
    public String toString() {
        return "Name Of country " + name  +
                "\nResortPlaces: " + Arrays.toString(resortPlaces) +
                "\n Resort Pl Count: " + resortCount;
    }

    double getTotalIncomeC(){
        double sum = 0;
        for (int i = 0; i < resortCount; i++) {

            sum += resortPlaces[i].getTotalIncome();
        }

        return sum;
    }
}
