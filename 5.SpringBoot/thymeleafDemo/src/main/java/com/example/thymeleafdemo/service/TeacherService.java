package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.model.Teacher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final List<Teacher> teachers = new ArrayList<>();

    public void createDataTeacher() {
        for (int i = 0; i < 10; i++) {
            Teacher teacher = Teacher.builder()
                    .id(i)
                    .name("Nguyễn Thị " + i)
                    .address("Hà Nội " + i)
                    .dob(LocalDate.now())
                    .chuyenNganh("môn" + i)
                    .build();
            teachers.add(teacher);
        }
    }

    public List<Teacher> getAllTeacher() {
        createDataTeacher();
        return teachers;
    }

