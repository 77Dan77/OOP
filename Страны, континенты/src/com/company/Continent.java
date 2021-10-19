package com.company;

import java.util.Arrays;

public class Continent {
    private String name;
    private int countryCount;
    public Country country[];

    public Continent(String name, int countryCount, Country[] country) {
        this.name = name;
        this.countryCount = countryCount;
        this.country = country;
    }

    public Continent(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryCount() {
        return countryCount;
    }

    public void setCountryCount(int countryCount) {
        this.countryCount = countryCount;
    }


    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                ", countryCount=" + countryCount +
                ", countries=" + Arrays.toString(country) +
                '}';
    }

    double getTotalIncomeOfAllResorts(Country[] country) {
        double sum = 0;
        for (int i = 0; i < countryCount; i++){
                sum += country[i].getTotalIncomeC();
        }
        return sum;
    }

    void getTheMostProfitableCountry() {

    }


}
