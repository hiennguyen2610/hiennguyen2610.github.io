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

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "introduce")
    String introduce;

    @Column(name = "dob")
    LocalDate dob;

    @Column(name = "level")
    DoctorLevel doctorLevel;
}
