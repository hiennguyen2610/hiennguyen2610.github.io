package com.example.employee;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class EmployeeApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void save_user_list() {
        List<Employee> employees = List.of(
                new Employee(null, "Hiển", "Tài chính", 1500000L, LocalDate.now()),
                new Employee(null, "Minh", "Vật tư", 200000L, LocalDate.now()),
                new Employee(null, "Hùng", "Thi công", 400000L, LocalDate.now()),
                new Employee(null, "Tài", "Kế hoạch", 500000L, LocalDate.now())
        );
        employeeRepository.saveAll(employees);
    }

}
