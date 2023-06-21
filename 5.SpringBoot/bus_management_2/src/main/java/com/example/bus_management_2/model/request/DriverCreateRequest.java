package com.example.bus_management_2.model.request;

import com.example.bus_management_2.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverCreateRequest extends PersonCreateRequest {
    @NotNull(message = "Level cannot be null")
    Level level;

}
