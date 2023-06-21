package com.example.bus_management.model;

import com.example.bus_management.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverModel extends PersonModel {
    Level level;
}
