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
            Main.TEACHINGS.add(teaching);
    }

    private void createTeachingDetail(TeachingDetail[] teachingDetails, int subjectNumber, Teacher teacher) {
        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = inputIDSubject(teacher);
            int numberOfClasses = inputNumberOfClasses(subject, teacher);
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

    private int inputNumberOfClasses(Subject subject, Teacher teacher) {
        System.out.print("Nhập số lượng lớp môn " + subject.getName() + " để giảng viên " + teacher.getName() + " dạy: ");
        int numberOfClasses;
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

    private Subject inputIDSubject(Teacher teacher) {
        System.out.print("Chọn id môn học cho giáo viên " + teacher.getName() + " muốn dạy: ");
        Subject subject = null;
        do {
            try {
                int subjectID = new Scanner(System.in).nextInt();
                for (Subject subj : Main.SUBJECTS) {
                    if (subj.getId() == subjectID) {
                        subject = subj;
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
                for (Teacher t : Main.TEACHERS) {
                    if (t.getId() == teacherID) {
                        teacher = t;
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
        for (Teaching teaching : Main.TEACHINGS) {
            if (teaching != null) {
                System.out.println(teaching);
            }
        }
    }

    public void sortByName() {
        Main.TEACHINGS.stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> o1.getTeacher().getName().compareToIgnoreCase(o2.getTeacher().getName()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void sortByTeachingDetail() {
    }

    public void tinhTienCong() {
        Main.TEACHINGS.stream()
                .filter(Objects::nonNull)
                .map(teaching -> {
                    double tongThuNhap = Arrays.stream(teaching.getTeachingDetails())
                            .filter(Objects::nonNull)
                            .mapToDouble(t -> (t.getSubject().getTheory() * t.getSubject().getExpense() * t.getNumberOfClasses()) + (((t.getSubject().getTotal() - t.getSubject().getTheory()) * 0.7 * t.getSubject().getExpense()) * t.getNumberOfClasses())).sum();
                    return "Tổng thu nhập của giáo viên " + teaching.getTeacher().getName() + " là " + tongThuNhap;
                }).forEach(System.out::println);
    }
}
