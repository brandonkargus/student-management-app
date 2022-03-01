package com.kargus.studentmanagementapp.repositories;

import com.kargus.studentmanagementapp.models.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByLastName(String lastName);

    List<Student> findByLastNameAndAge(String lastName, int age);

    List<Student> findByLastNameContaining(String keyword, Sort sort);

    @Query("FROM students WHERE lastName = :lastName OR gradeLevel = :gradeLevel")
    List<Student> getStudentsByLastNameOrGradeLevel(String lastName, int gradeLevel);



}
