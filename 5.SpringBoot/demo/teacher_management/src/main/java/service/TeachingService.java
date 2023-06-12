package service;

import entity.Subject;
import entity.Teacher;
import entity.Teaching;
import entity.TeachingDetail;
import main.Main;

import java.util.*;
import java.util.stream.Collectors;

public class TeachingService {

    public void createNewTeaching() {

        if (checkNullTeacher() || checkNullSubject()) {
            System.out.println("Cần thực hiện nhập giáo viên và môn học.");
            return;
        }

        System.out.print("Nhập số giáo viên muốn phân công: ");
        int teacherNumber = new Scanner(System.in).nextInt();

        for (int i = 0; i < teacherNumber; i++) {
            // Nhập id giáo viên muốn phân công
            Teacher teacher = inputIDTeacher(i);

            // Nhập số môn học mà giáo viên bên trên muốn dạy
            System.out.print("Nhập số môn học mà giáo viên muốn dạy: ");
            int subjectNumber = new Scanner(System.in).nextInt();

            TeachingDetail[] teachingDetails = new TeachingDetail[subjectNumber];

            // Method nhập thông tin giảng dạy
            createTeachingDetail(teachingDetails, subjectNumber, teacher);
            Teaching teaching = new Teaching(teacher, teachingDetails);
            saveTeaching(teaching);
        }
    }


    private void saveTeaching(Teaching teaching) {
        for (int i = 0; i < Main.TEACHINGS.length; i++) {
            if (Main.TEACHINGS[i] == null) {
                Main.TEACHINGS[i] = teaching;
                return;
            }
        }
    }

    private void createTeachingDetail(TeachingDetail[] teachingDetails, int subjectNumber, Teacher teacher) {
        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = inputIDSubject(i, teacher);
            int numberOfClasses = inputNumberOfClasses(subject, i, teacher);
            TeachingDetail teachingDetail = new TeachingDetail(subject, numberOfClasses);
            saveTeachingDetail(teachingDetail, teachingDetails);
        }
    }

    private void saveTeachingDetail(TeachingDetail teachingDetail, TeachingDetail[] teachingDetails) {
        for (int i = 0; i < teachingDetails.length; i++) {
            if (teachingDetails[i] == null) {
                teachingDetails[i] = teachingDetail;
                return;
            }
        }
    }

    private int inputNumberOfClasses(Subject subject, int i, Teacher teacher) {
        System.out.print("Nhập số lượng lớp môn " + subject.getName() + " để giảng viên " + teacher.getName() + " dạy: ");
        int numberOfClasses = -1;
        do {
            try {
                numberOfClasses = new Scanner(System.in).nextInt();
                if (numberOfClasses > 0 && numberOfClasses <= 3) {
                    int tongSoTietDay = 0;
                    tongSoTietDay += subject.getTotal() * numberOfClasses;
                    if (tongSoTietDay > 200) {
                        System.out.print("Số tiết dạy đã vượt quá 200, vui lòng nhập lại số lớp: ");
                        continue;
                    }
                    break;
                }
                System.out.print("Số lớp cho mỗi môn là số nguyên dương và không lớn hơn 3 ");
            } catch (InputMismatchException exception) {
                System.out.print("Vui lòng nhập lại: ");
            }
        } while (true);
        return numberOfClasses;
    }

    private Subject inputIDSubject(int i, Teacher teacher) {
        System.out.print("Chọn id môn học cho giáo viên " + teacher.getName() + " muốn dạy: ");
        Subject subject = null;
        do {
            try {
                int subjectID = new Scanner(System.in).nextInt();
                for (int j = 0; j < Main.SUBJECTS.length; j++) {
                    if (Main.SUBJECTS[j].getId() == subjectID) {
                        subject = Main.SUBJECTS[j];
                        break;
                    }
                }
                if (subject != null) {
                    break;
                }
                System.out.println("Không tìm thấy mã môn học trên, vui lòng nhập lại.");
            } catch (InputMismatchException exception) {
                System.out.print("Id môn học phải là số, vui lòng nhập lại: ");
            }

        } while (true);
        return subject;
    }

    // Nhập id giáo viên muốn phân công
    private Teacher inputIDTeacher(int num) {
        System.out.print("Nhập ID của giáo viên thứ " + (num + 1) + ": ");
        Teacher teacher = null;
        do {
            try {
                int teacherID = new Scanner(System.in).nextInt();
                for (int j = 0; j < Main.TEACHERS.length; j++) {
                    if (Main.TEACHERS[j].getId() == teacherID) {
                        teacher = Main.TEACHERS[j];
                        break;
                    }
                }
                if (teacher != null) {
                    break;
                }
                System.out.println("Không tìm thấy mã giáo viên trên, vui lòng nhập lại.");
            } catch (InputMismatchException exception) {
                System.out.print("Id giáo viên phải là số, vui lòng nhập lại: ");
            }

        } while (true);
        return teacher;
    }

    public void showTeachingDetail() {
        for (int i = 0; i < Main.TEACHINGS.length; i++) {
            if (Main.TEACHINGS[i] != null) {
                System.out.println(Main.TEACHINGS[i]);
            }
        }
    }

    public void sortByName() {
//        for (int i = 0; i < Main.TEACHINGS.length - 1; i++) {
//            if (Main.TEACHINGS[i] == null) {
//                continue;
//            }
//            for (int j = i + 1; j < Main.TEACHINGS.length; j++) {
//                if (Main.TEACHINGS[j] == null) {
//                    continue;
//                }
//                if (Main.TEACHINGS[i].getTeacher().getName().trim().compareToIgnoreCase(Main.TEACHINGS[j].getTeacher().getName().trim()) > 0) {
//                    Teaching temp = Main.TEACHINGS[i];
//                    Main.TEACHINGS[i] = Main.TEACHINGS[j];
//                    Main.TEACHINGS[j] = temp;
//                }
//            }
//        }
//        showTeachingList();

        Arrays.stream(Main.TEACHINGS)
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> o1.getTeacher().getName().compareToIgnoreCase(o2.getTeacher().getName()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

//    private void showTeachingList() {
//        for (int i = 0; i < Main.TEACHINGS.length; i++) {
//            if (Main.TEACHINGS[i] != null) {
//                System.out.println(Main.TEACHINGS[i]);
//            }
//        }
//    }

    public void sortByTeachingDetail() {
    }

    public void tinhTienCong() {
        Arrays.stream(Main.TEACHINGS)
                .filter(Objects::nonNull)
                .map(teaching -> {
                    double tongThuNhap = Arrays.stream(teaching.getTeachingDetails())
                            .filter(Objects::nonNull)
                            .mapToDouble(t -> (t.getSubject().getTheory() * t.getSubject().getExpense() * t.getNumberOfClasses()) + (((t.getSubject().getTotal() - t.getSubject().getTheory()) * 0.7 * t.getSubject().getExpense()) * t.getNumberOfClasses())).sum();
                    return "Tổng thu nhập của giáo viên " + teaching.getTeacher().getName() + " là " + tongThuNhap;
                }).forEach(System.out::println);
    }

    // Check xem danh sách lái xe có rỗng không
    private static boolean checkNullTeacher() {
        for (int i = 0; i < Main.TEACHERS.length; i++) {
            if (Main.TEACHERS[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Check xem danh sách tuyến có rỗng không
    private static boolean checkNullSubject() {
        for (int i = 0; i < Main.SUBJECTS.length; i++) {
            if (Main.SUBJECTS[i] != null) {
                return false;
            }
        }
        return true;
    }
}
