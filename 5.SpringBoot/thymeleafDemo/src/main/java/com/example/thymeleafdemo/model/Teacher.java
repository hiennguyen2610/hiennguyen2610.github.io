package com.example.thymeleafdemo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Teacher {
    int id;
    String name;
    String address;
    String phone;
    LocalDate dob;
    String chuyenNganh;
}
