package employee_management.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Employee {
    private int id;
    private String name;
    private String email;
    private int salary;
}
