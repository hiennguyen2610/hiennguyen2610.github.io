package com.example.demojpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")  // columnDefinition: set cứng vào CSDL
    private String name;

    @Column(name = "email", nullable = false, unique = true)  // nulltable: giá trị ko đc để trống, unique: giá trị ko đc trùng nhau
    private String email;

    @Column(name = "dob")
    private LocalDate birthday;

    @Column(name = "status")
    private Boolean status;

}
