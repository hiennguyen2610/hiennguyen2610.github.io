package com.example.hospital_management.service;

import com.example.hospital_management.entity.Appointment;
import com.example.hospital_management.entity.Patient;
import com.example.hospital_management.model.request.AppointmentRequest;
import com.example.hospital_management.repository.AppointmentRepository;
import com.example.hospital_management.repository.PatientRepository;
import com.example.hospital_management.statics.AppointmentStatus;
import com.example.hospital_management.statics.HealthInsuranceType;
import com.example.hospital_management.statics.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Appointment create(AppointmentRequest appointmentRequest){
        Patient patient = new Patient();
        patient.setAddress(appointmentRequest.getAddress());
        patient.setDob(appointmentRequest.getDob());
        patient.setEmail(appointmentRequest.getEmail());
        patient.setSymptom(appointmentRequest.getSymptom());
        patient.setName(appointmentRequest.getName());
        patient.setHealthInsuranceNumber(1);
        patient.setHealthInsuranceType(HealthInsuranceType.TYPE_1);
        patient.setPhone(appointmentRequest.getPhone());
        Patient resultPa = patientRepository.save(patient);

        Appointment appointment = new Appointment();
        appointment.setPaymentStatus(PaymentStatus.UNPAID);
        appointment.setAmount(0);
        appointment.setPaidAmount(0);
        appointment.setAppointmentStatus(AppointmentStatus.APPOINTMENT_CREATED);
        appointment.setDoctor(appointmentRequest.getDoctor());
        appointment.setSpeciality(appointmentRequest.getSpeciality());
        appointment.setSymptom(appointment.getSymptom());
        appointment.setPatient(resultPa);
        appointment.setCreatedDateTime(LocalDateTime.now());
        appointment.setCreatedBy(appointmentRequest.getEmail());
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setAppointmentTime(appointmentRequest.getAppointmentTime());
        Appointment result = appointmentRepository.save(appointment);
        return result;
    }

    public List<Appointment> findByDoctor(Long doctorId, Date date){
        return appointmentRepository.findByDoctor(doctorId, date);
    }
}
