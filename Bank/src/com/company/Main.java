package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter count of Bank applications: ");
        int countOfBankApp = sc.nextInt();

        BankApplication[] BA = new BankApplication[countOfBankApp];
        for(int j = 0; j < countOfBankApp; j++){
            System.out.println("Enter name of bank app: ");
            String nameb = sc.next();
            System.out.println("Enter count of accounts: ");
            int countOfAccount = sc.nextInt();
            Account[] ac = new Account[countOfAccount];

            for (int i = 0; i < countOfAccount; i++){
                System.out.println("Enter id of account: ");
                 int id = sc.nextInt();
                System.out.println("Enter name of account: ");
                 String name = sc.next();
                System.out.println("Enter surname of account: ");
                 String surname = sc.next();
                System.out.println("Enter balance of account: ");
                 double balance = sc.nextDouble();

                ac[i] = new Account(id,name,surname,balance);
            }

            BA[j] = new BankApplication(nameb);

            for (int i = 0; i < countOfAccount; i++) {
                BA[j].addAccount(ac[i]);
            }
        }

        ArrayList<BankApplication> bankApplications = new ArrayList<>();
        for (int i = 0; i < countOfBankApp; i++){
            bankApplications.add(BA[i]);
        }

        for (int i = 0; i < countOfBankApp; i++){
            for (int j = 0; j < countOfBankApp-1; j++){
                if (bankApplications.get(j).getAverageBalance() < bankApplications.get(j+1).getAverageBalance()){
                    Collections.swap(bankApplications, j, j+1);
                }
            }
        }

        for (int i = 0; i < countOfBankApp; i++){
            System.out.println(bankApplications.get(i).getBankData());
            System.out.println("");
        }

    }
}
