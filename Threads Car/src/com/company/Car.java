package com.company;

public class Car extends Thread {
    private String name;
    private int speed;
    private double distance;
    private int t = 1;

    public Car(String name, int speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public Car(){}

    @Override
    public void run() {

        try {
            double dist = 0;

            while(this.distance > dist){
                dist += speed;
                System.out.println(name + " in " + dist);
                t++;
                Thread.sleep(1000);

            }
            setTime(t);
            System.out.println(name + " Finished racing!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String gtName() {
        return this.name;
    }

    public void setTime(int t){
        this.t = t;
    }

    public int getTime(){
        return t;
    }


    public void stName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
