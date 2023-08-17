package com.example.hospital_management.service;

import com.example.hospital_management.entity.Doctor;
import com.example.hospital_management.entity.Speciality;
import com.example.hospital_management.entity.User;
import com.example.hospital_management.exception.NotFoundException;
import com.example.hospital_management.model.request.DoctorSearchRequest;
import com.example.hospital_management.model.request.UpdateDoctorRequest;
import com.example.hospital_management.model.response.CommonResponse;
import com.example.hospital_management.model.response.Doctor2Response;
import com.example.hospital_management.model.response.DoctorResponse;
import com.example.hospital_management.repository.DoctorRepository;
import com.example.hospital_management.repository.SpecialityRepository;
import com.example.hospital_management.repository.UserRepository;
import com.example.hospital_management.repository.custom.DoctorCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DoctorService {

    DoctorRepository doctorRepository;
    final SpecialityRepository specialityRepository;
    UserRepository userRepository;
    DoctorCustomRepository doctorCustomRepository;

    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    public List<DoctorResponse> getAllDoctorResponse() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorResponse> doctorResponses = new ArrayList<>();
        for (Doctor d : doctors) {
            DoctorResponse doctorResponse = DoctorResponse.builder()
                    .id(d.getId())
                    .doctorLevel(d.getDoctorLevel() == null ? "" : d.getDoctorLevel().getName())
                    .dob(d.getDob())
                    .address(d.getAddress())
                    .specialities(d.getSpecialities())
                    .user(d.getUser())
                    .introduce(d.getIntroduce())
                    .specialities(d.getSpecialities())
                    .gender(d.getUser().getGender().getName())
                    .build();
            doctorResponses.add(doctorResponse);
        }
        return doctorResponses;
    }

    public List<DoctorResponse> findBySpecialy(Long idSpecialy) {
        List<Doctor> doctors = doctorRepository.findBySpeciality(idSpecialy);
        List<DoctorResponse> doctorResponses = new ArrayList<>();
        for (Doctor d : doctors) {
            DoctorResponse doctorResponse = DoctorResponse.builder()
                    .id(d.getId())
                    .doctorLevel(d.getDoctorLevel() == null ? "" : d.getDoctorLevel().getName())
                    .dob(d.getDob())
                    .address(d.getAddress())
                    .specialities(d.getSpecialities())
                    .user(d.getUser())
                    .introduce(d.getIntroduce())
                    .specialities(d.getSpecialities())
                    .gender(d.getUser().getGender().getName())
                    .build();
            doctorResponses.add(doctorResponse);
        }
        return doctorResponses;
    }

    public void updateDoctor(Long id, UpdateDoctorRequest registrationRequest) {

        Doctor doctor = doctorRepository.findById(id).orElse(null);
        Set<Speciality> specialities = new LinkedHashSet<>();
        for (Long speciality : registrationRequest.getSpecialityIds()) {
            specialities.add(specialityRepository.findById(speciality).orElse(null));
        }
        if (doctor != null) {
            User user = doctor.getUser();
            userRepository.save(user);

            doctor.setUser(user);
            doctor.setPhone(registrationRequest.getPhone());
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

    public CommonResponse<?> searchDoctor(DoctorSearchRequest request) {
        try {
            List<Doctor2Response> doctors = doctorCustomRepository.searchDoctor(request);
            Integer pageIndex = request.getPageIndex();;
            Integer pageSize = request.getPageSize();

            PaginationUtils<Doctor2Response> paginationUtils = new PaginationUtils<>();
            int pageNumber = paginationUtils.getPageNumber(doctors, pageSize);
            doctors = paginationUtils.searchData(doctors, pageIndex, pageSize);

            return CommonResponse.builder()
                    .pageNumber(pageNumber)
                    .data(doctors)
                    .build();
        } catch (Exception e) {
            throw new NotFoundException("Page index out of bound");
        }
    }
}
