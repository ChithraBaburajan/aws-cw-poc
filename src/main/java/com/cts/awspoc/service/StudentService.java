package com.cts.awspoc.service;

// generate a service interface with functions for student CRUD operations

import com.cts.awspoc.entity.Student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(int id);


    Student   getStudentByName(String name);

    Student getStudentByEmail(String email);

    List<Student> getStudentsByAge(int age);

    List<Student> getStudentsByAgeBetween(int age1, int age2);
}