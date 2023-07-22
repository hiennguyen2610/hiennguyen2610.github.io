package com.example.hospital_management.model.request;

import com.example.hospital_management.entity.DoctorSpeciality;
import com.example.hospital_management.statics.DoctorLevel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationRequest {

    String name;

    String address;

    String phone;

    String introduce;

    String avatar;

    DoctorLevel doctorLevel;

    DoctorSpeciality doctorSpeciality;

    LocalDate dob;

    Boolean gender;

    @NotBlank
    @Size(max = 50)
    String email;

    @NotBlank
    String password;

}
