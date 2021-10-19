import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBManager manager = new DBManager();
        manager.connect();

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("PRESS 1 TO ADD STUDENT");
            System.out.println("PRESS 2 TO LIST STUDENTS");
            System.out.println("PRESS 3 TO DELETE STUDENT");
            System.out.println("PRESS 0 TO FINISH");

            int choice = input.nextInt();

            if(choice == 1){///INSERT DATA
                System.out.print("Input name: "); String name = input.next();
                System.out.print("Input surname: "); String surname = input.next();
                System.out.print("Input faculty: "); String faculty = input.next();
                System.out.print("Input group: "); String group = input.next();

                Student student = new Student(null, name, surname, faculty, group);
                manager.addStudent(student);
            }

            else if(choice == 2){///SELECT
                ArrayList<Student> list = manager.selectAllStudents();
                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i));
                }
            }

            else if(choice == 3){///DELETE
                ArrayList<Student> list = manager.selectAllStudents();
                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i));
                }
                System.out.println("--------------------------------------------------");
                System.out.println("Input index of the student that you want to delete");
                Long deleteIndex = input.nextLong();
                manager.deleteStudent(deleteIndex);
            }

            else if(choice == 0){
                break;
            }

        }
    }
}
