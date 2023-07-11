package com.example.expense_tracker_project.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "otps")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Otp extends BaseEntity{

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "otp_code")
    String otpCode;
}
