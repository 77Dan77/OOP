import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Student> stud = Student.getStudents();
        //1
        stud.stream().forEach(s -> System.out.print(s.getLastName() + ", "));
        System.out.println("\n--------");
        //2
        Double averageGPA = stud.stream().mapToDouble(Student::getGpa).average().getAsDouble();  //forEach(student -> System.out.println(student.getCity())
        System.out.println("Gpa is: " + averageGPA);
        System.out.println("--------");
        //3
        stud.stream().filter(s -> s.getCity().toLowerCase().contains("a")).map(Student::getCity).distinct().forEach(student -> System.out.print(student + ", "));
        System.out.println("\n--------");
        //4
        stud.stream().filter(s -> s.getLastSubmissionDate().getDayOfMonth() < 26).forEach(student -> System.out.print(student.getLastName() + ", "));
        System.out.println("\n--------");
        //5
        stud.stream().sorted(Comparator.comparingDouble(s -> s.getGpa() * (-1))).
                forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getGpa()));
        System.out.println("--------");
        //6
        Double min = stud.stream().mapToDouble(Student::getGpa).min().getAsDouble();
        Double max = stud.stream().mapToDouble(Student::getGpa).max().getAsDouble();
        stud.stream().filter(student -> (student.getGpa().equals(min)) || (student.getGpa().equals(max))).forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getGpa()));
        System.out.println("--------");
        //7
        Set<Student> set = stud.stream().collect(Collectors.toSet());
            System.out.println(set);

        System.out.println("--------");
        //8
        Map<String, Double> map = stud.stream().collect(Collectors.
                toMap(Student::getLastName,student -> student.getGpa(), (stud1, stud2) -> stud1 > stud2 ? stud1 : stud2));
        System.out.println(map);
        System.out.println("---------");
        //9
        map.entrySet().stream().filter(s -> s.getKey().equals("Mcneill")).map(Map.Entry::getKey).forEach(System.out::println);
        System.out.println("---------");
        //10
        map.entrySet().stream().filter(s -> s.setValue(s.getValue() + 0.08) > 0).forEach(s -> System.out.println(s));
    }
}
