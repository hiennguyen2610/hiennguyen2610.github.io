package service;

import entity.Subject;
import main.Main;

import java.util.Scanner;

public class SubjectService {

    // In danh sách môn học
    public   void showSubject() {
        for (Subject subject : Main.SUBJECTS) {
            if (subject != null) {
                System.out.println(subject);
            }
        }
    }

    // Nhập danh sách môn học
    public   void inputNewSubject() {
        System.out.print("Nhập số lượng môn học muốn thêm: ");
        int numberSubject = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberSubject; i++) {
            Subject subject = new Subject();
            System.out.print("Nhập tên môn học thứ "+(i+1)+" :");
            subject.inputInfo();
            saveSubject(subject);
        }
    }

    // Lưu danh sách môn học
    public   void saveSubject(Subject subject) {
        for (int i = 0; i < Main.SUBJECTS.length; i++) {
            if (Main.SUBJECTS[i] == null) {
                Main.SUBJECTS[i] = subject;
                return;
            }
        }
    }
}
