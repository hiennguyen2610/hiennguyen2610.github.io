package com.example.student_maganement_02.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    int id;
    String name;
    String address;
    String phone;
    LocalDate dob;
    float gpa;
}
