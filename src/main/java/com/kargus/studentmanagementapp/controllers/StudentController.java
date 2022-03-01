package com.kargus.studentmanagementapp.controllers;

import com.kargus.studentmanagementapp.models.Student;
import com.kargus.studentmanagementapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getSingleStudent(id), HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);

    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/students")
    public ResponseEntity<HttpStatus> deleteStudent(@RequestParam Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/students/filterByLastName")
    public ResponseEntity<List<Student>> getStudentsByLastName(@RequestParam String lastName) {
        return new ResponseEntity<List<Student>>(studentService.getStudentsByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/students/filterByLastNameAndAge")
    public ResponseEntity<List<Student>> getStudentsByLastNameAndAge(@RequestParam String lastName, @RequestParam int age) {
        return new ResponseEntity<List<Student>>(studentService.getStudentsByLastNameAndAge(lastName, age), HttpStatus.OK);
    }

    @GetMapping("/students/filterByLastNameContainingKeyword")
    public ResponseEntity<List<Student>> getStudentsByLastNameContainingKeyword(@RequestParam String keyword) {
        return new ResponseEntity<List<Student>>(studentService.getStudentsByLastNameContainingKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/students/{lastName}/{gradeLevel}")
    public ResponseEntity<List<Student>> getStudentsByLastNameOrGradeLevel(@PathVariable String lastName, @PathVariable int gradeLevel) {
        return new ResponseEntity<List<Student>>(studentService.getStudentsByLastNameOrGradeLevel(lastName, gradeLevel), HttpStatus.OK);
    }


}
