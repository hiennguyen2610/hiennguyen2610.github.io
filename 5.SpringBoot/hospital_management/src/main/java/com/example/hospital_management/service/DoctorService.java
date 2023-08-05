package com.example.hospital_management.service;

import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.Speciality;
import com.example.hospital_management.entity.User;
import com.example.hospital_management.exception.NotFoundException;
import com.example.hospital_management.model.request.DoctorRequest;
import com.example.hospital_management.model.request.RegistrationRequest;
import com.example.hospital_management.model.response.DoctorReponse;
import com.example.hospital_management.repository.DoctorRepository;
import com.example.hospital_management.repository.SpecialityRepository;
import com.example.hospital_management.repository.UserRepository;
import com.example.hospital_management.statics.DoctorLevel;
import com.example.hospital_management.statics.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DoctorService {
    ObjectMapper objectMapper;

    DoctorRepository doctorRepository;
    final SpecialityRepository specialityRepository;
    UserRepository userRepository;

    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    public List<DoctorReponse> getAllDoctorResponse() {
        List<Doctor> doctors = doctorRepository.findAll();

        List<DoctorReponse> doctorReponses = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorReponse doctorReponse = DoctorReponse.builder()
                    .user(doctor.getUser())
                    .doctorLevel(doctor.getDoctorLevel() == null ? "" : doctor.getDoctorLevel().getName())
                    .dob(doctor.getDob())
                    .address(doctor.getAddress())
                    .introduce(doctor.getIntroduce())
                    .phone(doctor.getPhone())
                    .specialities(doctor.getSpecialities())
                    .build();
            doctorReponses.add(doctorReponse);
        }
        return doctorReponses;
    }


    public void updateDoctor(Long id, RegistrationRequest registrationRequest) {

        Doctor doctor = doctorRepository.findById(id).orElse(null);
        Set<Speciality> specialities = new LinkedHashSet<>();
        for (Long speciality : registrationRequest.getSpecialityIds()) {
            specialities.add(specialityRepository.findById(speciality).orElse(null));
        }
        if (doctor != null) {
            User user = doctor.getUser();
            user.setName(registrationRequest.getName());
            user.setEmail(registrationRequest.getEmail());
            user.setGender(Gender.valueOf(registrationRequest.getGender()));
            userRepository.save(user);

            doctor.setUser(user);
            doctor.setPhone(registrationRequest.getPhone());
            doctor.setDob(registrationRequest.getDob());
            doctor.setDoctorLevel(registrationRequest.getDoctorLevel());
            doctor.setAddress(registrationRequest.getAddress());
            doctor.setIntroduce(registrationRequest.getIntroduce());
            doctor.setSpecialities(specialities);

            doctorRepository.save(doctor);
        }
    }

    public void deleteDoctor(Long id) throws NotFoundException {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found doctor"));
        doctorRepository.delete(doctor);
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
