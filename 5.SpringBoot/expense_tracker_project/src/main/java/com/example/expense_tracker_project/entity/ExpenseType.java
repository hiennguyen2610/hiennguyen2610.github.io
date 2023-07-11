package com.example.expense_tracker_project.entity;

import com.example.expense_tracker_project.statics.Types;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense_types")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseType extends BaseEntity{

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    Types types;

}
