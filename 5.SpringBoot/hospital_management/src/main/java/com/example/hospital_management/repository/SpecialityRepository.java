package com.example.hospital_management.repository;

import com.example.hospital_management.entity.Speciality;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    boolean existsByName(String name);

}
