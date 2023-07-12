package com.example.hospital_management.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Patient extends BaseEntity {

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "name")
    String name;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "dob")
    LocalDate dob;

    @Column(name = "symptom")
    String symptom;
}
