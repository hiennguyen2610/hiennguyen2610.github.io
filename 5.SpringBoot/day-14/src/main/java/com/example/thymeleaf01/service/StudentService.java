package com.example.thymeleaf01.service;

import com.example.thymeleaf01.entity.Student;
import com.example.thymeleaf01.model.StudentModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class StudentService {

    ObjectMapper objectMapper;
    List<Student> students = new ArrayList<>();

    private static int AUTO_ID = 1;



//    private void createData() {
//        for (int i = 0; i < 10; i++) {
//            StudentModel student = StudentModel.builder()
//                    .id(i)
//                    .name("Nguyễn Văn " + i)
//                    .address("Hà Nội " + i)
//                    .dob(LocalDate.now())
//                    .gpa(i)
//                    .build();
//            students.add(student);
//        }
//    }

    public List<StudentModel> getAlStudents() {
        List<StudentModel> result = new ArrayList<>();
        for (Student student : students) {
            //            StudentModel studentModel = StudentModel.builder()
//                    .id(student.getId())
//                    .name(student.getName())
//                    .address(student.getAddress())
//                    .phone(student.getPhone())
//                    .dob(student.getDob())
//                    .gpa(student.getGpa())
//                    .build();

            StudentModel studentModel = objectMapper.convertValue(student, StudentModel.class); // thay cho đoạn code trên
            result.add(studentModel);
        }
        return result;
    }

    public void delete(String id) {
        students.removeIf(s -> s.getId() == Integer.parseInt(id));
    }

    public StudentModel finfById(String id) {
        Optional<Student> studentOptional = students
                .stream()
                .filter(s -> s.getId() == Integer.parseInt(id))
                .findFirst();
        if (studentOptional.isEmpty()) {
            return null;
        }
        Student student = studentOptional.get();
        return objectMapper.convertValue(student, StudentModel.class);
    }

    public void updateStudent(StudentModel studentModel) {
        students.forEach(s -> {
            if (s.getId() != studentModel.getId()) {
                return;
            }
            s.setName(studentModel.getName());
            s.setAddress(studentModel.getAddress());
            s.setDob(studentModel.getDob());
            s.setGpa(studentModel.getGpa());
        });
    }


    public void saveStudent(StudentModel studentModel){
        Student student = objectMapper.convertValue(studentModel, Student.class);
        students.add(student);
    }
}
