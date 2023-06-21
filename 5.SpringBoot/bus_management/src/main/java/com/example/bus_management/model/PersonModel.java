package com.example.bus_management.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class PersonModel {
    int id;

    @NotBlank(message = "Tên tài xế không được để trống")
    @Size(max = 50, message = "Tên không được vượt quá 50 kí tự")
    String name;

    @Size(max = 50, message = "Địa không được vượt quá 50 kí tự")
    @NotBlank(message = "Địa chỉ không được để trống")
    String address;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải gồm 10 số")
    String phone;
}
