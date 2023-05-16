package com.example.student_maganement_02.service;

import com.example.student_maganement_02.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static final List<Student> students = new ArrayList<>();

    static  {
        for (int i = 0; i < 10; i++) {
            Student student =  Student.builder()
                    .id(i)
                    .name("Nguyễn Văn " + i)
                    .address("Hà Nội " + i)
                    .dob(LocalDate.now())
                    .gpa(i)
                    .build();
            students.add(student);
        }
    }

    public List<Student> getAlStudent() {
        return students;
    }
}
