package com.example.testspringweb.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    @NotBlank
    @Size(max = 255)
    String name;

    @NotNull
    @Min(value = 0, message = "Số tiền phải lớn hơn 0")
    Double price;

    String describle;

    String avatar;
}
