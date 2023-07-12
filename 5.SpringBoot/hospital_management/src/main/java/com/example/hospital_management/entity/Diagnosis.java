package com.example.hospital_management.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "diagnosis")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Diagnosis extends BaseEntity{

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(targetEntity = Speciality.class)
    @JoinColumn(name = "appointment_id")
    Appointment appointment;

    @Column(name = "name")
    String name;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;
}
