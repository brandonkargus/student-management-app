package com.kargus.studentmanagementapp.services;

import com.kargus.studentmanagementapp.models.Student;
import com.kargus.studentmanagementapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getSingleStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);   //TODO fix this
        if (student.isPresent()) {
            return student.get();
        }
        throw new RuntimeException("No student found with ID: " + id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);          //will contain added ID from SQL, saveStudent method does not
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public List<Student> getStudentsByLastNameAndAge(String lastName, int age) {
        return studentRepository.findByLastNameAndAge(lastName, age);
    }

    @Override
    public List<Student> getStudentsByLastNameContainingKeyword(String keyword) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return studentRepository.findByLastNameContaining(keyword, sort);
    }

    @Override
    public List<Student> getStudentsByLastNameOrGradeLevel(String lastName, int gradeLevel) {
        return studentRepository.getStudentsByLastNameOrGradeLevel(lastName, gradeLevel);
    }


}
