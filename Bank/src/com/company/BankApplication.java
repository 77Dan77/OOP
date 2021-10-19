package com.company;

import java.util.ArrayList;

public class BankApplication {
    private String name;
    ArrayList<Account>  accounts = new ArrayList();

    public BankApplication(String name) {
        this.name = name;
    }

    public void addAccount (Account a) {
        accounts.add(a);
    }
    public void removeAccount (int i) {
        accounts.remove(i);
    }

    public Account getMaxAccount () {
        double max = accounts.get(0).getBalance();
        int index = 0;
        for (int i = 1; i < accounts.size(); i++){
            if(max < accounts.get(i).getBalance()){
                max = accounts.get(i).getBalance();
                index = i;
            }
        }
        return accounts.get(index);
    }

    public double getAverageBalance () {
        double sum = 0;
        for(Account d:accounts){
            sum += d.getBalance();
        }
        double average = sum / accounts.size();

        return average;
    }

    public double getTotalBalance () {
        double sum = 0;
        for(Account d:accounts){
            sum += d.getBalance();
        }
        return sum;
    }

    public int totalAccounts () {
        return accounts.size();
    }

    public String getBankData (){

        return "Name: " + name + "; Number of Accounts: " + totalAccounts() + "; Balance amount: " + getTotalBalance() + "; Average balance: " + getAverageBalance();
    }
}
