package com.example.hospital_management.repository;

import com.example.hospital_management.entity.DiagnosisDetail;
import com.example.hospital_management.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosisDetailRepository extends JpaRepository <DiagnosisDetail, Long> {

    List<DiagnosisDetail> findAllByService(Service service);

}
