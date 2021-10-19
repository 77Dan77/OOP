package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Student.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("St.txt"));
            String text = " ";
            ArrayList<Student> students = new ArrayList<>();
            while((text=reader.readLine())!=null){
                String arr[] = text.split(" ");
                Student st = null;
                if(Double.parseDouble(arr[1]) < 2.0){
                    continue;
                }
                double salary = Double.parseDouble(arr[2]);
                if(Double.parseDouble(arr[1]) > 4.5){
                    double percent = Double.parseDouble(arr[2]) * 0.3;
                    salary = Double.parseDouble(arr[2]) + percent;

                }

                st = new Student(arr[0], Double.parseDouble(arr[1]), salary);

                students.add(st);
                writer.write(st.toString() + " \n");
                students.sort(Comparator.comparing(Student::getSalary));

            }

            for (Student s: students){
                System.out.println(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
