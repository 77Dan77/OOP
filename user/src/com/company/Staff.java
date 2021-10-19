package com.company;

import java.util.ArrayList;

public class Staff extends User{
    public final String rank = "Staff";
    public double salary;
    public ArrayList<String> subjects = new ArrayList<>();

    public Staff(double salary) {
        this.salary = salary;
        this.subjects = subjects;
    }

    public Staff(int id, String login, String password, String name, String surname, double salary) {
        super(id, login, password, name, surname);
        this.salary = salary;
        this.subjects = subjects;
    }

    public  void addSub(String s){
        subjects.add(s);
    }

    @Override
    public String getData() {
        return rank + " " + super.getData() + " " + salary + " " + subjects;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }
}
