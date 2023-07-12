package com.example.hospital_management.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Service extends BaseEntity {

    @ManyToOne(targetEntity = Speciality.class)
    @JoinColumn(name = "department_id")
    Speciality department;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Integer price;
}
