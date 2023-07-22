package com.example.hospital_management.repository;

import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    Optional<Doctor> findByEmail(String email);

}
