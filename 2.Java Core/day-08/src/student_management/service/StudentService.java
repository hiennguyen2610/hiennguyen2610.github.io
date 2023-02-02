package student_management.service;

import student_management.model.Student;

import java.util.Random;
import java.util.Scanner;

public class StudentService {
    public Student createStudent() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int id = rd.nextInt(100) + 1;

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter theoryPoint: ");
        double theoryPoint = sc.nextDouble();

        System.out.print("Enter practicePoint: ");
        double practicePoint = sc.nextDouble();

        return new Student(id, name, theoryPoint, practicePoint);
    }

    public double calculateAvgPoint(double theoryPoint, double practicePoint) {
        return (theoryPoint + practicePoint) / 2;
    }

    public void printInfo(Student s) {
        System.out.println("id : " + s.id);
        System.out.println("name : " + s.name);
        System.out.println("theoryPoint : " + s.theoryPoint);
        System.out.println("practicePoint : " + s.practicePoint);
        System.out.println("avgPoint: " + calculateAvgPoint(s.theoryPoint, s.practicePoint));

    }
}