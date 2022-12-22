package abstract_class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Tester extends Employee {
    private int error;

    public Tester(int id, String name, int age, int salaryBasic, int error) {
        super(id, name, age, salaryBasic);
        this.error = error;
    }


    @Override
    public int calculateSalary() {
        return this.getSalaryBasic() + this.error * 50_000;
    }
}
