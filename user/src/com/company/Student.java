package com.company;

import java.util.ArrayList;

public class Student extends User{
    public final String rank = "Student";
    public double gpa;
    public ArrayList<String> courses = new ArrayList<>();

    @Override
    public String getData() {
        return rank + " " + super.getData() + " " + gpa + " " + courses;

    }

    public Student(double gpa) {
        this.gpa = gpa;
    }

    public Student(int id, String login, String password, String name, String surname, double gpa) {
        super(id, login, password, name, surname);
        this.gpa = gpa;
    }

    public  void addCourse(String s){
        courses.add(s);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
}
