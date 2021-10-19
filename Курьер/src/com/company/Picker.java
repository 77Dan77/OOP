package com.company;

public class Picker implements Worker {
    private double salary;
    Warehouse wh;

    @Override
    public void doWork() {
        this.salary += 80;
        getWh().setCountOrder(getWh().getCountOrder()+1);
    }

    @Override
    public void bonus() {
            this.salary = this.salary * 3;
    }

    public Picker(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Picker(double salary, Warehouse wh) {
        this.salary = salary;
        this.wh = wh;
    }

    public Warehouse getWh() {
        return wh;
    }

    public void setWh(Warehouse wh) {
        this.wh = wh;
    }
}
