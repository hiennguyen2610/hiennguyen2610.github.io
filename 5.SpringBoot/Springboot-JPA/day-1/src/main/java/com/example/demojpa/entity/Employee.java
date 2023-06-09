package com.example.demojpa.entity;

import com.example.demojpa.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.*;

@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "resultInfo",
                classes = @ConstructorResult(
                        targetClass = EmployeeDto.class,
                        columns = {
                                @ColumnResult(name = "id"),
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "email")
                        }
                )
        )
})
@NamedNativeQuery(
        name = "getEmployeeDtoUsingNQ",
        resultSetMapping = "resultInfo",                                // b2. đặt tên cho kết quả
        query = "select id, name email from employee where email = ?1"  // b1: định nghĩa câu lệnh query
)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String email;

    private String password;
}
