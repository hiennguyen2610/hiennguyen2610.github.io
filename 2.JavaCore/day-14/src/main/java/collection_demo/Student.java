package collection_demo;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student implements Comparable<Student> {
    private String name;
    private double point;

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", 8.5));
        students.add(new Student("Anna", 9));
        students.add(new Student("Victor", 7));
        students.add(new Student("Chris", 6.5));

        System.out.println("Danh sách học sinh: ");
        show(students);

        Collections.sort(students);
        System.out.println("Danh sách sau khi sắp xếp: ");
        show(students);
    }
    public static void show(ArrayList<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
