package com.example.expense_tracker_project.repository;

import com.example.expense_tracker_project.entity.Role;
import com.example.expense_tracker_project.statics.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

}
