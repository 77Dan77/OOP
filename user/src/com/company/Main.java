package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Staff> staff = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("count of staff: ");
        int countOfstaff = sc.nextInt();
        for (int i = 0; i < countOfstaff; i++){
            System.out.println("id str str str srt str salary of staff: ");
            staff.add(new Staff(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble()));

            System.out.println("count of subject: ");
            int countOfsub = sc.nextInt();
            ArrayList<String> sub = new ArrayList<>();
            for (int j = 0; j < countOfsub; j++) {
                System.out.println("name of subj: ");
                sub.add(sc.next());
                staff.get(i).addSub(sub.get(j));
            }
        }
        System.out.println("count of students: ");
        int countOfstud = sc.nextInt();
        for (int i = 0; i < countOfstud; i++){
            System.out.println("id str str str srt str gpa of student: ");
            students.add(new Student(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble()));

            System.out.println("count of courses: ");
            int cour = sc.nextInt();
            ArrayList<String> course = new ArrayList<>();
            for (int j = 0; j < cour; j++) {
                System.out.println("name of course: ");
                course.add(sc.next());
                students.get(i).addCourse(course.get(j));
            }
        }

        for (int j = 0; j <countOfstaff; j++){
            users.add(staff.get(j));
        }
        for ( int i = 0; i < countOfstud; i++){
            users.add(students.get(i));
        }

        boolean RemovedAcc = false;
        while (true) {
            if(users.size() == 0) {
                System.out.println("No accounts in database! exiting...");
                System.exit(1);
            }

            if (RemovedAcc == true) {
                RemovedAcc = false;

                System.out.println("Account was deleted, do you want to continue session with other account? " +
                        " ([1] - Yes; [2] - No)");
                int choiseToContinue = sc.nextInt();
                if (choiseToContinue == 1) continue;
                else if(choiseToContinue == 2) {
                    System.exit(0);
                }
                else{
                    System.exit(1);
                }}

            System.out.println("Enter login and password of your account: ");
            String log = sc.next();
            String pass = sc.next();

            for (int i = 0; i < users.size(); i++){

                if (users.get(i).getLogin().equals(log) && users.get(i).getPassword().equals(pass)){
                    System.out.println("Welcome " + users.get(i).getName());

                    boolean ii = true;
                    while(ii) {

                        System.out.println("PRESS [1] TO EDIT LOGIN\n");
                        System.out.println("PRESS [2] TO CHANGE PASSWORD");
                        System.out.println("PRESS [3] TO DELETE OWN ACCOUNT");
                        System.out.println("PRESS [0] TO EXIT");
                        int choise = sc.nextInt();

                        if (choise == 1) {
                            System.out.println("-----------------------------------------");
                            System.out.println("Edit your login: ");
                            users.get(i).setLogin(sc.next());
                            System.out.println("New login is: " + users.get(i).getLogin());
                            System.out.println("...");
                            continue;
                        }

                        else if (choise == 2) {
                            System.out.println("-----------------------------------------");
                            System.out.println("To edit password write your old password: ");
                            String tempPass = sc.next();
                            if (tempPass.equals(users.get(i).getPassword())){
                                System.out.println("Insert new password: ");
                                String NewPass = sc.next();
                                users.get(i).setPassword(NewPass);
                                System.out.println("New passeord is: " + users.get(i).getPassword());
                            }
                            else {
                                System.out.println("Password is incorrect, try again: ");
                                continue;
                            }

                        }

                        else if (choise == 3) {
                            System.out.println("-----------------------------------------");
                            System.out.println("You want to delete your account. Are you sure? ([1] - Yes; [2] - No)");
                            int choiseDel = sc.nextInt();
                            if (choiseDel == 1) {
                                users.remove(i);
                                RemovedAcc = true;
                                ii = false;

                            }
                            else if (choiseDel == 2) continue;
                        }

                        else if (choise == 0) {
                            System.exit(0);
                        }


                    }


                }
                if ((i == users.size()-1) && RemovedAcc != true) {
                    System.out.println("Incorrect password or login, please try again");
                    break;
                }
                else {
                    continue;
                }

            }


        }






    }
}
