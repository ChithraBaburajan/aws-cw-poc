package com.cts.awspoc.controller;

import com.cts.awspoc.entity.Student;
import com.cts.awspoc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Generate a Spring REST Controller with CRUD methods
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Generate REST api for getting all students
    @GetMapping("/allstudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //Generate REST api for adding a student
    @PostMapping("/addstudent")
    public Student addStudent(Student student) {
        //check if a student with the same student id already exists
        return studentService.addStudent(student);
    }

    //Generate REST api for updating a student for the given url student id
    @PutMapping("/updatestudent/{studentId}")
    public Student updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    //Generate REST api for deleting a student
    @DeleteMapping("/deletestudent/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
    }

    //Generate REST api for getting a student for the given url student id
    @GetMapping("student/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return studentService.getStudentById(studentId);
    }


    @GetMapping("/getstudentsbyage/{age}")
    public List<Student> getStudentsByAge(@PathVariable int age) {

        return studentService.getStudentsByAge(age);
    }

}