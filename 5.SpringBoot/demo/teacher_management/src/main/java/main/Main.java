package main;

import entity.Subject;
import entity.Teacher;
import entity.Teaching;
import service.TeachingService;

import java.util.Scanner;

public class Main {

    public static Teacher[] TEACHERS = new Teacher[200];
    public static Subject[] SUBJECTS = new Subject[200];
    public static Teaching[] TEACHINGS = new Teaching[200];

    public static TeachingService teachingService = new TeachingService();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean isExit = false;
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputNewTeacher();
                    break;
                case 2:
                    showTeacher();
                    break;
                case 3:
                    inputNewSubject();
                    break;
                case 4:
                    showSubject();
                    break;
                case 5:
                    teachingService.createNewTeaching();
                    break;
                case 6:
                    teachingService.showTeachingDetail();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    isExit = true;
            }
        } while (!isExit);
    }

    private static void createNewTeaching() {
    }

    // In danh sách môn học
    private static void showSubject() {
        for (Subject subject : Main.SUBJECTS) {
            if (subject != null) {
                System.out.println(subject);
            }
        }
    }

    // Nhập danh sách môn học
    private static void inputNewSubject() {
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
    private static void saveSubject(Subject subject) {
        for (int i = 0; i < Main.SUBJECTS.length; i++) {
            if (Main.SUBJECTS[i] == null) {
                Main.SUBJECTS[i] = subject;
                return;
            }
        }
    }

    // Nhập danh sách giảng viên
    private static void inputNewTeacher() {
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
    private static void saveTeacher(Teacher teacher) {
        for (int i = 0; i < Main.TEACHERS.length; i++) {
            if (Main.TEACHERS[i] == null) {
                Main.TEACHERS[i] = teacher;
                return;
            }
        }
    }

    // In danh sách giảng viên
    private static void showTeacher() {
        for (Teacher teacher : Main.TEACHERS) {
            if (teacher != null) {
                System.out.println(teacher);
            }
        }
    }

    // Chọn menu
    private static int functionChoice() {
        showMenu();
        System.out.print("Xin mời chọn chức năng: ");

        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
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
