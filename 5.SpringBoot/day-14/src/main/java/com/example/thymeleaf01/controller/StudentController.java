package com.example.thymeleaf01.controller;

import com.example.thymeleaf01.model.StudentModel;
import com.example.thymeleaf01.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    //    @Autowired
    StudentService studentService;

    //    @RequestMapping
    @GetMapping
    public String getStudents(Model model) {
        List<StudentModel> students = studentService.getAlStudents();
        model.addAttribute("danhSachSinhVien", students);
        return "student-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateForm(Model model, StudentModel student) {
        model.addAttribute("sinhVienToiMuonTaoMoi", student);
        return "create-student";
    }

    @PostMapping
    public String createNewStudent(@ModelAttribute("student") StudentModel student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }


}
