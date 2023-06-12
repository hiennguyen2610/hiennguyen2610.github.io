package service;

import entity.Teacher;
import main.Main;
import java.util.Scanner;

public class TeacherService {

    // Nhập danh sách giảng viên
    public void inputNewTeacher() {
        System.out.print("Nhập số lượng giảng viên muốn thêm: ");
        int numberTeacher = new Scanner(System.in).nextInt();
        for (int i = 0; i < numberTeacher; i++) {
            Teacher teacher = new Teacher();
            System.out.print("Nhập tên giảng viên thứ "+(i+1)+" :");
            teacher.inputInfo();
            saveTeacher(teacher);
        }
    }

    // Lưu thông tin giảng viên
    public static void saveTeacher(Teacher teacher) {
        Main.TEACHERS.add(teacher);
    }

    // In danh sách giảng viên
    public void showTeacher() {
        for (Teacher teacher : Main.TEACHERS) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }
}
