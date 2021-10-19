package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("PRESS [1] TO ADD STUDENT\n" +
                    "PRESS [2] TO LIST STUDENTS\n" +
                    "PRESS [0] TO EXIT\n");
            int num = 0;
            try {
                 num = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (num == 1) {
                System.out.println(" ");
                System.out.println("Enter name , surname of student: ");
                String name = "";
                String surname = "";
                try {
                    name = reader.readLine();
                    surname = reader.readLine();

                    System.out.println("PRESS [1] TO ADD SUBJECT\n" +
                            "PRESS [0] TO GO TO MAIN MENU\n");
                    int num2 = Integer.parseInt(reader.readLine());

                    if (num2 == 1) {
                        System.out.println(" ");
                        System.out.println("Enter subjects name and credits: ");
                        subjects.add(new Subject(reader.readLine(), Integer.parseInt(reader.readLine())));
                        System.out.println("Завершился ввод предметов...");
                    } else if (num2 == 0) {
                        continue;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                students.add(new Student(name, surname, subjects));
                saveListOfStudents(students);
            }

            else if (num == 2){
                System.out.println(" ");
                ArrayList<Student> newStudents = new ArrayList<>();
                newStudents = getListOfStudents();
                for (Student u: newStudents){
                    System.out.println(u.toString());
                }
            }

            else if (num == 0){
                System.out.println(" ");
                System.out.println("Exiting programm...");
                System.exit(0);
            }



        }



    }

    public static void saveListOfStudents(ArrayList<Student> students){

        try{
            ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("memory.txt", true));
            write.writeObject(students);
            write.close();
        }catch (Exception e){
            System.out.println("error writer");
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> getListOfStudents(){
        ArrayList<Student> students = null;
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream("memory.txt"));
            students = new ArrayList<>();
            students = (ArrayList<Student>)read.readObject();
            read.close();
        }catch (Exception e){
            System.out.println("error reader!");
            e.printStackTrace();
        }
        return students;
    }
}
