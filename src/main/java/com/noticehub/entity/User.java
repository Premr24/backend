package com.noticehub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    @Builder.Default
    private Status status = Status.active;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public enum Status {
        active,
        inactive
    }
}
