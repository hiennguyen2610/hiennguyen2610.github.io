package com.example.student_maganement_02.service;

import com.example.student_maganement_02.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final List<Student> teachers = new ArrayList<>();

    public void createDataTeacher() {
        for (int i = 0; i < 10; i++) {
            Student teacher = Student.builder()
                    .id(i)
                    .name("Nguyễn Thị " + i)
                    .address("Hà Nội " + i)
                    .dob(LocalDate.now())
                    .build();
            teachers.add(teacher);
        }
    }


    }

