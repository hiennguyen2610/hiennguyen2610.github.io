package com.example.bus_management.entity;

import com.example.bus_management.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver extends Person {

    Level level;
    public Driver(int id, String name, String address, String phone, Level level) {
        super(id, name, address, phone);
        this.level = level;
    }
}
