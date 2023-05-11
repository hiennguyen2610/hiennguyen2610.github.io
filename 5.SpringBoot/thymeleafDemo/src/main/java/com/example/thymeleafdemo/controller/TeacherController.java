package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import com.example.thymeleafdemo.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @RequestMapping
    public String getTeacher(Model model) {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Teacher teacher =  Teacher.builder()
                    .id(i)
                    .name("Nguyễn Thị " + i)
                    .address("Điện Biên " + i)
                    .dob(LocalDate.now())
                    .build();
            teachers.add(teacher);
        }
        model.addAttribute("danhSachGiaoVien", teachers);
        return "teacher-list";
    }
}
