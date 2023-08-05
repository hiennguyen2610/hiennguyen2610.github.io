package com.example.hospital_management.statics;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    String name;
}
