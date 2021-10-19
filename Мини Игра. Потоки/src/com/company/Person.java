package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Person extends Thread {
    private String name;
    private String class_of_pers;
    private int job_level;
    private int health;
    private double exp = 0;
    private int time = 0;
    private boolean check = true;

    @Override
    public void run() {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        try {
            Thread.sleep(1000);
            this.time += 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (check){
            if (this.job_level > 20){
                System.out.println(name + " достиг уровня " + job_level + ", победа!");
                check = Check();
                break;
            };

            if (this.health <= 0){
                System.out.println("-------------- " + name + " Died! -------------");
                System.out.println("\n");
                check = Check();
                break;
            }


        try {
            BufferedReader reader = new BufferedReader(new FileReader("job"));
            String text = "";

            int number = 1 + (int) (Math.random() * 24);
            while ((text = reader.readLine()) != null){
                String a[] = text.split(":");
                if(Integer.parseInt(a[0]) == number){
                    String arr[] = text.split("/");
                    getJob(Person.this, arr[0], arr[1], arr[2], arr[3]);
                    break;
                }
            }

            Thread.sleep(400);
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (InterruptedException e) {
        }
        }

    }

    public boolean Check(){
        return false;
    }



    public Person(String name, String class_of_pers, int job_level, int health) {
        this.name = name;
        this.class_of_pers = class_of_pers;
        this.job_level = job_level;
        this.health = health;

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNname() {
        return name;
    }

    public void setNname(String name) {
        this.name = name;
    }

    public String getClass_of_pers() {
        return class_of_pers;
    }

    public void setClass_of_pers(String class_of_pers) {
        this.class_of_pers = class_of_pers;
    }

    public int getJob_level() {
        return job_level;
    }

    public void setJob_level(int job_level) {
        this.job_level = job_level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }


     synchronized public static void getJob(Person p, String name_of_job, String class_of_pers, String job_level, String prize){
        System.out.println(p.getNname() + " (HP:" + p.getHealth() + ") пытатеся выполнить задние: " + name_of_job);
        if (p.getClass_of_pers().toLowerCase().equals(class_of_pers.toLowerCase())) {
            if (Integer.parseInt(job_level) > p.getJob_level()) {
                System.out.println("Попытка персонажа выполнить задание не увенчалась успехом! " + p.getNname() + " теряет 10 очков здоровья!");
                p.setHealth(p.getHealth()-10);
                System.out.println("Общий опыт персонажа: " + p.getExp() + ", Оствшееся здоровье: " + p.getHealth());
                System.out.println("*************************************************************");
                System.out.println("\n\n");
            } else {
                System.out.println("_____________________________________________________________________");
                System.out.println("Задание выполнено! ");
                p.setExp(p.getExp() + Double.parseDouble(prize));
                p.setHealth(p.getHealth() + 5);
                System.out.println(p.getNname() + " получает " + prize + " опыта и 5 очков здоровья!");
                System.out.println("Общий опыт персонажа: " + p.getExp());

                if(p.getExp() >= (p.getJob_level()*600)){
                    p.setJob_level(p.getJob_level()+1);
                    System.out.println(" ");
                    System.out.println("Уровень героя " + p.getNname() + " повышается!!! Теперь он: " + p.getJob_level());
                }
                System.out.println("*************************************************************");
                System.out.println("\n\n");
            }

        } else {
            System.out.println("Этот персонаж не умеет делать такое! ");
            System.out.println("*************************************************************");
            System.out.println("\n\n");
        }

    }

    @Override
    public String toString() {
        return  name + class_of_pers + ", job level - " + job_level +
                ", health - " + health +
                ", exp - " + exp;
    }
}
