package com.example.bus_management.model;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverAssignmentModel {
    int id;

    int driverId;
    String driverName;

    int routeId;
    String routeName;

    @NotNull(message = "Số lượt không được để trống")
    @Range(min = 1, max = 15, message = "Số lượt nằm trong khoảng từ 1 đến 15")
    Integer quanlity;

    @NotNull(message = "Ngày chạy không được để trống")
    @FutureOrPresent(message = "Ngày chạy phải sau hôm nay")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
