package employee_management.repository;

import employee_management.database.EmployeeDatabase;
import employee_management.model.Employee;

import java.util.ArrayList;

public class EmployeeRepository {
    public ArrayList<Employee> findAll() {
        return EmployeeDatabase.employees;
    }

    public void save(Employee employee) {
        EmployeeDatabase.employees.add(employee);
    }

    public ArrayList<Employee> findByNameContainIgnoreCase(String name) {
        ArrayList<Employee> rs = new ArrayList<>();
        for (Employee e : EmployeeDatabase.employees) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(e);
            }
        }
        return rs;
    }

    public Employee findById(int id) {
        for (Employee e : EmployeeDatabase.employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void deleteByID(int id) {
        ArrayList<Employee> toRemove = new ArrayList<>();
        for (Employee e :
                EmployeeDatabase.employees) {
            toRemove.add(e);
        }
    }

    public ArrayList<Employee> findBySalary(int minSalary, int maxSalary) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        for (Employee e :
                EmployeeDatabase.employees) {
            if (e.getSalary() >= minSalary && e.getSalary() <= maxSalary) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }
}
