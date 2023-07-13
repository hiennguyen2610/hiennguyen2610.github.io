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
@Table(name = "dianosis_detail")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiagnosisDetail extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "diagnosis_id")
    Diagnosis diagnosis;

    @ManyToOne
    @JoinColumn(name = "service_id")
    Service service;

    @Column(name = "detail")
    String detail;

    @Column(name = "result")
    String result;
}
