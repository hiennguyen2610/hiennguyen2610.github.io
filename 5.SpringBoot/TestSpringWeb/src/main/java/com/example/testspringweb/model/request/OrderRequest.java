package com.example.testspringweb.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {
    @Size(max = 100, message = "Tên không được vượt quá 100 kí tự")
    @NotBlank(message = "Tên không được để trống")
    String name;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại phải nhập bằng số")
    String phone;

    @NotBlank
    @Email
    String email;
}
