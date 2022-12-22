package abstract_class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

abstract class Employee {
    private int id;
    private String name;
    private int age;
    private int salaryBasic;

    // Điểm danh
    public void register() {
        System.out.println("Register ...");
    }

    // Tính lương
    abstract public int calculateSalary();

}
