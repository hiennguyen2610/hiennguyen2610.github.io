package com.example.hospital_management.entity;

import com.example.hospital_management.statics.DoctorLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Doctor extends BaseEntity {

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(targetEntity = Speciality.class)
    @JoinColumn(name = "department_id")
    Speciality department;

    @Column(name = "name")
    String name;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "dob")
    LocalDate dob;

    @Column(name = "level")
    DoctorLevel doctorLevel;
}
