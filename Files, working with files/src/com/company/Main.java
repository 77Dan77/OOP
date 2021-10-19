package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader("jobs"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("jobs", true));
        ArrayList<Handyman> man = new ArrayList<>();

        while (true){
            try {
                Handyman ultraman = new Handyman(){
                    @Override
                    public boolean giveWork(String workLine, String money, String nameJob) {
//                        getBankAccount() += Integer.parseInt(money) * 1.5;
                        return true;
                    }
                };

                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("men.txt"));
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("men.txt"));
                System.out.println("PRESS [1] View workers. [2] TO Add worker. [3] TO Add job. [4] Give job. [5] to EXIT");
                int num = Integer.parseInt(reader.readLine());

                ArrayList<Handyman> newWorkers = new ArrayList<>();
                if (num == 1) {
                    newWorkers = (ArrayList<Handyman>)inputStream.readObject();

                    for (Handyman h: newWorkers){
                        System.out.println(h.toString());
                    }
                    reader.close();

                }

                else if (num == 2) {
                    System.out.println("Enter id, name, level, bankAcc: ");
                    int id = Integer.parseInt(reader.readLine());
                    String name = reader.readLine();
                    int level = Integer.parseInt(reader.readLine());
                    int bankAccount = Integer.parseInt(reader.readLine());
                    man.add(new Handyman(id, name, level, bankAccount));
                    outputStream.writeObject(man);
                    outputStream.close();
                }

                else if (num == 3) {
                    String text = reader.readLine();
                    writer.write("\n" + text);
                    writer.close();
                }

                else if (num == 4){
                    System.out.println("Enter index of work: ");
                    int index = Integer.parseInt(reader.readLine());

                    for (Handyman h: newWorkers){
                        System.out.println(h.toString());
                    }

                    System.out.println("Enter index of worker: ");
                    int indWorker = Integer.parseInt(reader.readLine());

                    int i = 0;
                    String textt = " ";
                    while ((textt=reader1.readLine()) != null){
                        i++;
                        if (i == index) {
                            String arr[] = textt.split("/");
                            System.out.println(man.get(indWorker).giveWork(arr[2], arr[1], arr[0]));
                            break;
                        }
                    }
                    reader1.close();
                    reader.close();
                }

                else if (num == 0){
                    System.exit(0);
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

}
