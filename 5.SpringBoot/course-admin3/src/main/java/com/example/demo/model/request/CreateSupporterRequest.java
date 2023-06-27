package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupporterRequest {

    @Size(max = 50)
    String name;

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number characters")
    String phone;

}
