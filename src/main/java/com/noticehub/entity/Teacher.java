package com.noticehub.entity;

import com.noticehub.enums.Gender;
import com.noticehub.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_number", nullable = false, unique = true)
    private String idNumber;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    @Column(length = 500, nullable = false)
    private String address;

    @Column(length = 50, unique = true, nullable = false)
    private String contact;

    @Lob
    @Column(name = "profile_image")
    private byte[] profileImage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    @Builder.Default
    private Status status = Status.ACTIVE;

    @Column(length = 500)
    private String description;

    @Column(length = 500, nullable = false)
    private String qualification;

    @Column(length = 500)
    private String specialization;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(optional = false)
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "authority_id", nullable = false)
    private Authority authority;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_type_id", nullable = false)
    private JobType jobType;



}
