package abstract_class;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Developer(1, "Hiển", 10, 10_000_000, 30);
        System.out.println(employee.calculateSalary());

        Employee employee1 = new Tester(2, "Quang Hiển", 10, 12_000_000,40);
        System.out.println(employee1.calculateSalary());

        System.out.println();

        // Tạo 1 danh sách nhân viên
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(new Developer(3, "Minh", 20, 11_000_000, 30));
        employees.add(new Tester(4, "Mi", 22, 8_000_000, 100));

        for (Employee e : employees) {
            System.out.println(e.getSalaryBasic());
        }
        // Sắp xếp theo lương giảm dần
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.calculateSalary() - o1.calculateSalary();
            }
        });

            System.out.println("Lương giảm dần");
            for (Employee e1: employees) {
                System.out.println(e1.calculateSalary());
            }

    }
}
