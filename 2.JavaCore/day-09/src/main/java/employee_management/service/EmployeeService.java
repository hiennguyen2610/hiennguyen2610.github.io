package employee_management.service;

import employee_management.model.Employee;
import employee_management.repository.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    Employee employee = new Employee();

    public void printEmployee() {
        ArrayList<Employee> rs = employeeRepository.findAll();
        for (Employee e:
             rs) {
            System.out.println(e);
        }
    }

    public void printAddEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void printFindByName(String name) {
        for (Employee e: employeeRepository.findByNameContainIgnoreCase(name)) {
            System.out.println(e);
        }
    }

    public void printFindById(int id) {
        System.out.println(employeeRepository.findById(id));
    }

    public void printDeleteById(int id) {
        employeeRepository.deleteByID(id);
    }

    public void printFindBySalary(){
        System.out.println(employeeRepository.findBySalary(5000000,10000000));
    }
}
