package com.company;

public class Student {

    private String name;
    private double mark;
    private double salary;

    @Override
    public String toString() {
        return name + " " + mark + " " + salary;
    }

    public Student(String name, double mark, double salary) {
        this.name = name;
        this.mark = mark;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
