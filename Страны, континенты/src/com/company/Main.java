package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Continent continent = new Continent();

        System.out.println("Input the name of the Continent:  ");
        continent.setName(sc.next());
        System.out.println("Input the count of Countries:  ");
        continent.setCountryCount(sc.nextInt());

        Country[] country = new Country[continent.getCountryCount()];

        for (int k = 0; k < country.length; k++) {

            System.out.println("Input the name of the Country:  ");
            String Cname = sc.next();
            System.out.println("Input the number of Resorts:  ");
            int CResCount = sc.nextInt();

            ResortPlace[] rp = new ResortPlace[CResCount];

            for (int i = 0; i < rp.length; i++) {
                System.out.println("Input the name of Resort:  ");
                String Pname = sc.next();
                System.out.println("Input the city:  ");
                String Pcity = sc.next();
                System.out.println("Input the number of tourists:  ");
                int tourCount = sc.nextInt();

                Tourist[] tourists = new Tourist[tourCount];

                for (int j = 0; j < tourists.length; j++) {
                    System.out.println("Input the name of tourist:  ");
                    String Tname = sc.next();
                    System.out.println("Input the incom money by the tourist:  ");
                    double incomM = sc.nextDouble();

                    tourists[j] = new Tourist(Tname, incomM);
                }

                rp[i] = new ResortPlace(Pname, Pcity, tourists, tourCount);

            }

            country[k] = new Country(Cname, CResCount, rp);
        }



        System.out.println("Total income of all resorts is: ");
        System.out.println(continent.getTotalIncomeOfAllResorts(country));

        System.out.println("___________________________________");

        for (int i = 0; i < continent.getCountryCount(); i++){
            System.out.println("Total income of " + country[i].getName() + " is: " + country[i].getTotalIncomeC());
        }

        System.out.println("______________________________________");

        MostProfitableCountry(country,continent);

        System.out.println("____________________________________");

       MostProfitableResortInTheMostProfitableCountry(continent,country,country[MostProfitableCountryIndex(country,continent)].resortPlaces);

        System.out.println("____________________________________");


    }

    public static void  MostProfitableResortInTheMostProfitableCountry(Continent continent, Country[] country, ResortPlace[] rp){
        double max = country[MostProfitableCountryIndex(country,continent)].resortPlaces[0].getTotalIncome();
        int index = 0;

            for (int j = 0; j < country[MostProfitableCountryIndex(country,continent)].getResortCount(); j++){
                if(max < country[MostProfitableCountryIndex(country,continent)].resortPlaces[j].getTotalIncome()) {
                    max = country[MostProfitableCountryIndex(country,continent)].resortPlaces[j].getTotalIncome();
                    index = j;
                }
            }
        System.out.println("Most Profitable Resort In The Most Profitable Country: ");
        System.out.println(country[MostProfitableCountryIndex(country,continent)].resortPlaces[index].toString2());
        System.out.println("It's profit is: " + max + " USD");

    }

    public static void MostProfitableCountry(Country[] country, Continent continent){
        double max = country[0].getTotalIncomeC();
        int index = 0;

        for (int i = 0; i < continent.getCountryCount(); i++){
            if(max < country[i].getTotalIncomeC()) {
                max = country[i].getTotalIncomeC();
                index = i;
            }
        }

        System.out.println("The most profitable country with " + max + " USD of profit is: ");
        System.out.println(country[index]);

    }

    public static int MostProfitableCountryIndex(Country[] country, Continent continent){
        double max = country[0].getTotalIncomeC();
        int index = 0;

        for (int i = 0; i < continent.getCountryCount(); i++){
            if(max < country[i].getTotalIncomeC()) {
                max = country[i].getTotalIncomeC();
                index = i;
            }
        }
        return index;
    }

}