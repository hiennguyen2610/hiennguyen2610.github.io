package com.example.bus_management_2.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteUpdateRequest {
    int id;

    @NotBlank(message = "distance cannot be blank!")
    String name;

    @NotBlank(message = "distance cannot be blank!")

    String distance;

    @Min(value = 0, message = "stopover cannot be less than 0")
    int stopover;

}
