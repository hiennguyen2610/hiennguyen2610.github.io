package com.example.hospital_management.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppointmentStatus {
    APPOINTMENT_CREATED,
    ADMIN_APPROVED,
    ADMIN_REJECTED,
    DOCTOR_APPROVED,
    DOCTOR_REJECTED,
    CANCELLED,
    DELETED
}
