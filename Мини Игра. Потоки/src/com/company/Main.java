package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("Oleg", "Warrior", 1, 140);
        Person p2 = new Person("Don", "Paladin", 1, 120);
        Person p3 = new Person("Gendalf", "Wizzard", 1, 100);

        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);


        for (int i = 0; i < people.size(); i++) {
           people.get(i).start();
        }

        for (int i = 0; i < people.size(); i++) {
            try {
                people.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        people.sort(Comparator.comparing(Person::getExp));
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Список победителей! ");

        for(int i = people.size()-1; i >= 0; i--){
            System.out.println(people.get(i).toString());
        }



    }


}
