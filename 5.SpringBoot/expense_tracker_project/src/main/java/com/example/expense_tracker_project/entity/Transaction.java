package com.example.expense_tracker_project.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "expense_type_id")
    ExpenseType expenseType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Column(name = "price")
    Integer price;

    @Column(name = "date")
    LocalDate date;


}
