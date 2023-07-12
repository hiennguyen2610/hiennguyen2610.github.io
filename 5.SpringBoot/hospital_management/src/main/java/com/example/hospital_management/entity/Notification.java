package com.example.hospital_management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
public class Notification extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "content")
    String content;

    @Column(nullable = false, columnDefinition = "BOOLEAN default false")
    boolean seen;
}
