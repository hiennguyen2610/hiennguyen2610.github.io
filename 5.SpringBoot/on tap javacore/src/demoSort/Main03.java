package demoSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main03 {
    public static void main(String[] args) {
        Student[] sinhVien = new Student[10];
        for (int i = 0; i < 10; i++) {
            sinhVien[i] = new Student(i, "Nguyễn Văn " +i,i);
        }

        System.out.println(Arrays.toString(sinhVien));

        List<Student> students = Arrays.asList(sinhVien);  // truyền cho mảng thành 1 list
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return(int) (o1.getGpa() - o2.getGpa());
            }
        });

        students.sort((o1, o2) -> {
            return(int) (o1.getGpa() -o2.getGpa());
        });
        students.sort((o1, o2) -> (int) (o1.getGpa() - o2.getGpa()));
        students.sort(Comparator.comparing(Student::getGpa));

        for (int i = 0; i < sinhVien.length; i++) {
            for (int j = i+1; j < sinhVien.length; j++) {
                if (sinhVien[i].getGpa() > sinhVien[j].getGpa()) {
                    Student temp = sinhVien[i];
                    sinhVien[i] = sinhVien[j];
                    sinhVien[j] = temp;
                }

            }

        }
    }
}
