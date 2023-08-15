package com.example.hospital_management.repository.custom;

import com.example.hospital_management.entity.Speciality;
import com.example.hospital_management.model.request.DoctorSearchRequest;
import com.example.hospital_management.model.response.Doctor2Response;
import com.example.hospital_management.model.response.DoctorResponse;
import com.example.hospital_management.model.response.DoctorSearchResponse;
import com.example.hospital_management.repository.BaseRepository;
import com.example.hospital_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DoctorCustomRepository extends BaseRepository {
    @Autowired
    UserRepository userRepository;

    public List<Doctor2Response> searchDoctor(DoctorSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        HashMap<String, Object> parameters = new HashMap<>();
        sql.append("select ");
        sql.append("b.id, ");
        sql.append("b.phone, ");
        sql.append("u.name, ");
        sql.append("GROUP_CONCAT(speciality.name SEPARATOR ', ') specialities, ");
        sql.append("b.address, ");
        sql.append("b.introduce, ");
        sql.append("u.gender, ");
        sql.append("b.dob, ");
        sql.append("b.level, ");
        sql.append("u.avatar ");
        sql.append("from doctors b ");
        sql.append("left join doctor_speciality AS doc_spec ON b.id=doc_spec.doctor_id ");
        sql.append("left join specialities AS speciality ON doc_spec.speciality_id=speciality.id ");
        sql.append("LEFT JOIN users u ON u.id=b.user_id ");
        sql.append("where 1=1");

        if (request.getName() != null && !request.getName().trim().equals("")) {
            sql.append(" and lower(u.name) like :name");
            parameters.put("name", "%" + request.getName().toLowerCase() + "%");
        }
//        if (request.getAuthor() != null && !request.getAuthor().trim().equals("")) {
//            sql.append(" and lower(b.author) like :author");
//            parameters.put("author", "%" + request.getAuthor().toLowerCase() + "%");
//        }
//        if (request.getAll() != null && !request.getAll().trim().equals("")) {
//            sql.append(" and lower(b.author) like :author or lower(b.title) like :title");
//            parameters.put("author", "%" + request.getAll().toLowerCase() + "%");
//            parameters.put("title", "%" + request.getAll().toLowerCase() + "%");
//        }

        sql.append(" group by b.id");


        List<DoctorSearchResponse> doctorSearchResponses = getNamedParameterJdbcTemplate().query(sql.toString(), parameters, BeanPropertyRowMapper.newInstance(DoctorSearchResponse.class));
        List<Doctor2Response> doctorResponseList = new ArrayList<>();
        doctorSearchResponses.forEach(doctorSearchResponse -> {
            Doctor2Response doctorResponse = Doctor2Response.builder()
                    .id(doctorSearchResponse.getId())
                    .name(doctorSearchResponse.getName())
                    .phone(doctorSearchResponse.getPhone())
                    .specialities(convertSpeciality(doctorSearchResponse.getSpecialities()))
                    .address(doctorSearchResponse.getAddress())
                    .introduce(doctorSearchResponse.getIntroduce())
                    .dob(doctorSearchResponse.getDob())
                    .doctorLevel(doctorSearchResponse.getDoctorLevel())
                    .gender(doctorSearchResponse.getGender())
                    .build();
            doctorResponseList.add(doctorResponse);
        });
        return doctorResponseList;
    }

    private Set<Speciality> convertSpeciality(String SpecialityString) {
        Set<Speciality> specialitySet = new HashSet<>();
        if (SpecialityString != null && !SpecialityString.isEmpty()) {
            String[] specialitiesArray = SpecialityString.split(", ");
            for (String s : specialitiesArray) {
                Speciality speciality = new Speciality();
                speciality.setName(s);
                specialitySet.add(speciality);
            }
        }
        return specialitySet;
    }
}
