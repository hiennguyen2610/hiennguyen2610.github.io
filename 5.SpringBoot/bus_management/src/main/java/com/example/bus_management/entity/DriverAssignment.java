package com.example.bus_management.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverAssignment {
    int id;
    Driver driver;
    Route route;
    Integer quanlity;
    LocalDate date;
}
