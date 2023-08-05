package com.example.hospital_management.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum DoctorLevel {
    GIAO_SU("Giáo Sư"),
    TIEN_SI("Tiến Sĩ"),
    THAC_SI("Thạc Sĩ"),
    BSCK_II("BS Chuyên Khoa II"),
    BSCK_I("BS Chuyên Khoa I");

    String name;

    DoctorLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
