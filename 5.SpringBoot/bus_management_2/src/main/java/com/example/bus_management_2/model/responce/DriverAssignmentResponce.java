package com.example.bus_management_2.model.responce;

import com.example.bus_management_2.entity.Driver;
import com.example.bus_management_2.entity.Route;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class DriverAssignmentResponce {
    int id;
    Driver driver;
    Route route;
    int quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate date;
}
