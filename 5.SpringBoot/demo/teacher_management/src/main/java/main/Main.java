package main;

import entity.Subject;
import entity.Teacher;
import entity.Teaching;
import service.SubjectService;
import service.TeacherService;
import service.TeachingService;

import java.util.List;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static List<Teacher> TEACHERS = new ArrayList<>();
    public static List<Subject> SUBJECTS = new ArrayList<>();
    public static List<Teaching> TEACHINGS = new ArrayList<>();

    public static TeachingService teachingService = new TeachingService();
    public static TeacherService teacherService = new TeacherService();
    public static SubjectService subjectService = new SubjectService();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean isExit = false;
        do {
            try {
                int functionChoice = functionChoice();
                switch (functionChoice) {
                    case 1 -> teacherService.inputNewTeacher();
                    case 2 -> teacherService.showTeacher();
                    case 3 -> subjectService.inputNewSubject();
                    case 4 -> subjectService.showSubject();
                    case 5 -> teachingService.createNewTeaching();
                    case 6 -> teachingService.showTeachingDetail();
                    case 7 -> teachingService.sortByName();
                    case 8 -> teachingService.sortByTeachingDetail();
                    case 9 -> teachingService.tinhTienCong();
                    case 10 -> isExit = true;
                }
            } catch (InputMismatchException exception) {
                System.out.print("Vui lòng nhập lại là một số nguyên: ");
            }
        } while (!isExit);
    }

    // Chọn menu
    private static int functionChoice() {
        showMenu();
        System.out.print("Xin mời chọn chức năng: ");

        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 10) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    // Menu
    private static void showMenu() {
        System.out.println("----------PHẦN MỀM QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN----------");
        System.out.println("1. Nhập giảng viên mới.");
        System.out.println("2. In ra danh sách giảng viên.");
        System.out.println("3. Nhập môn học mới.");
        System.out.println("4. In ra danh sách môn học.");
        System.out.println("5. Nhập bảng phân công giảng dạy cho mỗi giảng viên.");
        System.out.println("6. In danh sách phân công.");
        System.out.println("7. Sắp xếp danh sách phân công theo họ tên giảng viên.");
        System.out.println("8. Sắp xếp danh sách phân công theo số tiết giảng dạy mỗi môn (giảm dần).");
        System.out.println("9. Lập bảng tính tiền công cho mỗi giảng viên.");
        System.out.println("10. Thoát chương trình.");
    }
}
