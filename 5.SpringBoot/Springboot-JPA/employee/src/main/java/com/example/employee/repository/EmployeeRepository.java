package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Method JPA:
    List<Employee> findByDepartment(String department);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE department = ?1", nativeQuery = true)
    List<Employee> findByDepartment1(String department);

    // Method JPA:
    List<Employee> findBySalaryGreaterThan(Long salary);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE salary > ?1", nativeQuery = true)
    List<Employee> findBySalaryGreaterThan1(Long salary);

    // Method JPA:
    List<Employee> findByName(String name);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE name = ?1", nativeQuery = true)
    List<Employee> findByName1(String name);

    // Method JPA:
    List<Employee> findByNameContainingIgnoreCase(String keyword);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE LOWER(name) LIKE CONCAT('%', LOWER(?1), '%')", nativeQuery = true)
    List<Employee> finhByNameContainingIgnoreCase1(String keyword);

    // Method JPA:
    List<Employee> findByNameStartingWith(String prefix);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE name LIKE CONCAT(?1, '%')", nativeQuery = true)
    List<Employee> findByNameStartingWith1(String prefix);

    // Method JPA:
    List<Employee> findBySalaryBetween(Long minSalary, Long maxSalary);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE salary BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Employee> findBySalaryBetween1(Long minSalary, Long maxSalary);

    // Method JPA:
    int countByDepartment(String department);
    // Native Query:
    @Query(value = "SELECT COUNT(*) FROM employee WHERE department = ?1", nativeQuery = true)
    int countByDepartment1(String department);

    // Method JPA:
    List<Employee> findByNameContainingIgnoreCaseAndDepartment(String keyword, String department);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE LOWER(name) LIKE CONCAT('%', LOWER(?1), '%') AND department = ?2", nativeQuery = true)
    List<Employee> findByNameContainingIgnoreCaseAndDepartment1(String keyword, String department);

    // Method JPA:
    List<Employee> findByNameOrDepartment(String name, String department);
    // Native Query:
    @Query(value = "SELECT * FROM  employee WHERE name = ?1 or department = ?2", nativeQuery = true)
    List<Employee> findByNameOrDepartment1(String name, String department);

    // Method JPA:
    List<Employee> findByJoiningDateAfter(LocalDate date);
    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE joining_date > ?1", nativeQuery = true)
    List<Employee> findByJoiningDateAfter1(LocalDate date);
}
