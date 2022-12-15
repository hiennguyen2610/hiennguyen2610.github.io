package constructor_demo;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee("Hien", 20, "HaNoi", 210);
        System.out.println(employee.getSalary());
        System.out.println(employee);

        Employee employee1 = new Employee("Hien", 20, "HaNoi", 90);
        System.out.println(employee1.getSalary());
    }

}
