//package com.example.demojpa.repository;
//
//import com.example.demojpa.entity.Student;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface StudentRepository extends JpaRepository<Student, Integer> {
//
//
//    // Sử dụng method querry
//    Page<Student> findByName(String name, Pageable pageable);
//
//    List<Student> findByNamedOrderByNameDesc(String name);
//    List<Student> findByName(String name, Sort sort);
//
//    // Sử dụng native query
//    @Query(nativeQuery = true, value = "select * from student where name = ?1 order by name desc ")
//    List<Student> findByNameSort(String name);
//
//
//    // Sử dụng native query
//    @Query(nativeQuery = true, value = "select * from student", countQuery = "select count (id) from student")
//    Page<Student> getAllStudent(Pageable pageable);
//
//
//    // Sử dụng method query
//    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);
//
//    // Sử dụng native query
//    @Query(nativeQuery = true, value = "SELECT * FROM students s WHERE LOWER(name) LIKE CONCAT('%', LOWER (?1), '%')",
//            countQuery = "SELECT count(s.id) FROM students s WHERE LOWER(s.name) like CONCAT('%', LOWER (?1), '%') ")
//    Page<Student> findByNameContainingIgnoreCaseUsingNQ(String name, Pageable pageable);
//}
