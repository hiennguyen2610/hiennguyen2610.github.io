package com.example.bus_management_2.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class DriverAssignment {
    int id;
    Driver driver;
    Route route;
    int quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;


}
