package com.example.hospital_management.entity;

import com.example.hospital_management.statics.AppointmentStatus;
import com.example.hospital_management.statics.PaymentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Appointment extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    Patient patient;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    Speciality speciality;

    @Column(name = "appointment_datetime")
    LocalDate appointment_datetime;

    @Column(name = "status")
    AppointmentStatus appointmentStatus;

    @Column(name = "symptom")
    String symptom;

    @Column(name = "amount")
    Integer amount;

    @Column(name = "payment_status")
    PaymentStatus paymentStatus;

    @Column(name = "paid_amount")
    Integer paidAmount;
}
