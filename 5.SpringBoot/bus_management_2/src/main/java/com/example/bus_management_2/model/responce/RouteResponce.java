package com.example.bus_management_2.model.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteResponce {
    int id;
    String name;
    String distance;
    int stopover;

}
