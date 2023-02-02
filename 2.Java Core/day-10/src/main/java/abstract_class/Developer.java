package abstract_class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Developer extends Employee {
    private int overtimeHours;

    public Developer(int id, String name, int age, int salaryBasic, int overtimeHours) {
        super(id, name, age, salaryBasic);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public int calculateSalary() {
        return this.getSalaryBasic() + this.overtimeHours * 200_000;
    }
}
