package com.company;

public class Courier implements Worker {
    private double salary;
    Warehouse wh;

    @Override
    public void doWork() {
        this.salary += 100;
        getWh().setBalance(getWh().getBalance()+1000);
    }

    @Override
    public void bonus() {
          this.salary = this.salary * 2;
    }

    public Courier(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Courier(double salary, Warehouse wh) {
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
