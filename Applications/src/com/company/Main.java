package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write count of iphone contacts: ");
        int countOfIcont = sc.nextInt();
        System.out.println("Write count of samsung contacts: ");
        int countOfScont = sc.nextInt();

	    IPhoneContact icont[] = new IPhoneContact[countOfIcont];
	    SamsungContact scont[] = new SamsungContact[countOfScont];

	    for (int i = 0; i < countOfIcont; i++){
             System.out.println("Write id of iphone contact: ");
             int id = sc.nextInt();
            System.out.println("Write name of iphone contact: ");
             String name = sc.next();
            System.out.println("Write surname of iphone contact: ");
             String surname = sc.next();
            System.out.println("Write first number of iphone contact: ");
             String firstPhone = sc.next();
            System.out.println("Write second number of iphone contact: ");
             String secondPhone = sc.next();
            System.out.println("Write third number of iphone contact: ");
             String thirdPhone = sc.next();

             icont[i] = new IPhoneContact(id,name,surname,firstPhone,secondPhone,thirdPhone);
        }

	    for (int i = 0 ; i < countOfScont; i++){
            System.out.println("Write id of samsung contact: ");
             int id = sc.nextInt();
            System.out.println("Write fullname of samsung contact: ");
             String fullName = sc.next();

            System.out.println("Write count of numbers of this contact: ");
             int countOFphones = sc.nextInt();

             String phones[] = new String[countOFphones];

             for (int j = 0; j < countOFphones; j++){
                 System.out.println("Write " + (j+1) + " number of samsung contact: ");
                 phones[j] = sc.next();
             }
            scont[i] = new SamsungContact(id, fullName, phones);
        }

        System.out.println("Write name of Iphone Application: ");
	    String nameOfiphoneApp = sc.next();
	    int icontsize = icont.length;


        IPhoneApplication Iapp = new IPhoneApplication(nameOfiphoneApp,icontsize);
        for(int i = 0; i < icontsize; i++){
            Iapp.addContact(icont[i]);
        }


        System.out.println("Write name of Samsung Application: ");
        String nameOfSamsungApp = sc.next();
        int scontsize = icont.length;
        SamsungApplication Sapp = new SamsungApplication(nameOfSamsungApp,scontsize);
        for(int i = 0; i < countOfScont; i++){
            Sapp.addContact(scont[i]);
        }


        System.out.println(" ");
        System.out.println("All contacts of both Aplications: ");
        System.out.println(" ");


        Iapp.printContacts();
        System.out.println(" ");
        Sapp.printContacts();









    }
}
