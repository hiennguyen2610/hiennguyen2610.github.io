package constructor_demo;

public class Employee {

    // Thuộc tính
    public String name;
    public int age;
    public String address;
    public int totalHours;

    // Constructor không tham số
    public Employee() {
    }

    // Constructor có tham số
    public Employee(String name, int age, String address, int totalHours) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.totalHours = totalHours;
    }

    public void printInfo() {

    }

    public int getSalary() {
        int salary = totalHours * 200_000;
        return salary + getBonus(salary);
    }

    public int getBonus(int salary) {
        if (totalHours >= 200) return (int) (salary * 0.2);
        if (totalHours >= 100) return (int) (salary * 0.1);
        return 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", totalHours=" + totalHours +
                '}';
    }
}
