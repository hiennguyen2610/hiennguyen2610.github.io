package employee_management.database;

import employee_management.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {
    public static ArrayList<Employee> employees = new ArrayList<>(List.of(
            new Employee(1, "Nguyễn Văn A", "A@gmail.com", 7_000_000),
            new Employee(2, "Nguyễn Văn B", "B@gmail.com", 8_000_000),
            new Employee(3, "Nguyễn Văn C", "C@gmail.com", 9_000_000),
            new Employee(4, "Nguyễn Văn BBBB", "BBBB@gmail.com", 7_500_000),
            new Employee(5, "Nguyễn Văn FFF", "FFF@gmail.com", 11_000_000),
            new Employee(6, "Nguyễn Văn AAAA", "AAAA@gmail.com", 15_000_000)
    ));

}
