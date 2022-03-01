package com.kargus.studentmanagementapp.services;

import com.kargus.studentmanagementapp.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student saveStudent(Student student);

    Student getSingleStudent(Long id);

    void deleteStudent(Long id);

    Student updateStudent(Student student);

    List<Student> getStudentsByLastName(String lastName);

    List<Student> getStudentsByLastNameAndAge(String lastName, int age);

    List<Student> getStudentsByLastNameContainingKeyword(String keyword);

    List<Student> getStudentsByLastNameOrGradeLevel(String lastName, int gradeLevel);
}
