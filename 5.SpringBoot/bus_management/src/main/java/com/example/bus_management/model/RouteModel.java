package com.example.bus_management.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteModel {
    int id;

    @NotBlank(message = "Tên tuyến không được để trống")
    @Size(max = 255, message = "Tên tuyến không được vượt quá 255 kí tự")
    String name;

    @NotNull(message = "Khoảng cách tuyến không được dể trống")
    @Range(max = 100, min = 1, message = "Khoảng cách tuyến lớn hơn 1km và nhỏ hơn 100km")
    Double distance;

    @NotNull(message = "Số điểm dừng không được để trống")
    @Min(value = 1, message = "Số điểm dừng phải lớn hơn 0")
    Integer stopover;
}
