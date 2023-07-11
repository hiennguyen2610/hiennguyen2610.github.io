package com.example.expense_tracker_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "budgets")
public class Budget extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "expected_budget")
    Integer expected_budget;

    @Column(name = "start_day")
    LocalDate start_day;

    @Column(name = "end_day")
    LocalDate end_day;

}
