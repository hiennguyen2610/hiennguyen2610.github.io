package com.example.bus_management_2.statics;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public enum Level {
    A("Loại A"),
    B("Loại B"),
    C("Loại C"),
    D("Loại D"),
    E("Loại E"),
    F("Loại F");
    String name;


}
