package com.example.demojpa.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmployeeDto {
    private Integer id;
    private String name;
    private String email;
}

// C1: Query Entity -> Mapper -> Dto
// Mapper có thể tự viết hoặc sử dụng thư viện: Object Mapper, MapStruct
// C2: JPQL
// C3: Native Query
// C4: Sử dụng Projection (interface)