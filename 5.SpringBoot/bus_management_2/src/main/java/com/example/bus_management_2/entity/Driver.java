package com.example.bus_management_2.entity;


import com.example.bus_management_2.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Driver extends Person {
    int id;
    Level level;


}
