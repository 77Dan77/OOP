package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Handyman implements Serializable {
   private int id;
   private String name;
   private int level;
   private int bankAccount;
   private ArrayList<String> taskDoneList = new ArrayList<>();


   public boolean giveWork (String workLine, String money, String nameJob){
       if ((level > Integer.parseInt(workLine)) || (level == Integer.parseInt(workLine))){
           bankAccount += Integer.parseInt(money);
           taskDoneList.add(nameJob);
           return true;
        }
       else{
           return false;
       }

   }

   public int getNumberOfWorkDone(){
        return taskDoneList.size();
   }

   public void showWorkDone(){
        for (String s: taskDoneList){
            System.out.print(s + " ");
        }
   }

   public Handyman(){}

    @Override
    public String toString() {
        return id + " " + name + " " +
                " " + bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    public ArrayList<String> getTaskDoneList() {
        return taskDoneList;
    }



    public Handyman(int id, String name, int level, int bankAccount, ArrayList<String> taskDoneList) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.bankAccount = bankAccount;
        this.taskDoneList = taskDoneList;
    }

    public Handyman(int id, String name, int level, int bankAccount) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.bankAccount = bankAccount;
    }
}
