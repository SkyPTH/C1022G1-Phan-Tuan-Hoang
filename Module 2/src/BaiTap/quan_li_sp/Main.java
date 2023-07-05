package BaiTap.quan_li_sp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 19));
        students.add(new Student("Charlie", 21));
        students.add(new Student("Alice", 25));

        // Sắp xếp theo Comparable
        Collections.sort(students);
        System.out.println("Sắp xếp theo Comparable:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sắp xếp theo Comparator
        Collections.sort(students, new StudentComparator());
        System.out.println("Sắp xếp theo Comparator:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
