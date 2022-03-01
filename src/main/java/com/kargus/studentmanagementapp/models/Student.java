package com.kargus.studentmanagementapp.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "first name should not be null")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name should not be null")
    @Column(name = "last_name")
    private String lastName;

    private int age = 0;

    @NotBlank(message = "address should not be null")
    private String address;

    @Email(message = "Please enter the valid email address")
    @NotBlank(message = "email should not be null")
    private String email;

    @NotNull(message = "grade level should not be null")
    @Column(name = "grade_level")
    private int gradeLevel;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;


}
