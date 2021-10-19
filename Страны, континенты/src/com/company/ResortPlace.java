package com.company;

import java.util.Arrays;

public class ResortPlace {
    private String name;
    private String city;
    private int touristCount;
    public Tourist tourists[];




    public ResortPlace(String name, String city, Tourist[] tourists, int touristCount) {
        this.name = name;
        this.city = city;
        this.tourists = tourists;
        this.touristCount = touristCount;
    }

    public void Arr(Tourist[] tourists) {
        this.tourists = tourists;
    }

    public ResortPlace() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Resort: " + name + ",  City: " + city + "\n";
    }

    public String toString2() {
        return "Resort: " + name + ",  City: " + city + " tourist count: " + touristCount + " tourists:  " + Arrays.toString(tourists) + "  ";
    }



    public double getTotalIncome() {
        double sum = 0;
        for(int i = 0; i < touristCount; i++){
            sum += tourists[i].getIncomeMoney();
        }

        return sum;
    }


    public int getTourists() {
        return touristCount;
    }
}

