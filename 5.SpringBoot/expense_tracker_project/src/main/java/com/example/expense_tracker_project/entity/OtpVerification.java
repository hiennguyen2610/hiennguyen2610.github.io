package com.example.expense_tracker_project.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "otp_verifications")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OtpVerification extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "otp_id")
    Otp otp;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean success;

    @Column(nullable = false)
    Integer timesVerification;

}
