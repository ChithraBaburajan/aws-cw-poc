package com.cts.awspoc.service;

import com.cts.awspoc.entity.Student;
import com.cts.awspoc.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {StudentServiceImpl.class})
public class StudentServiceImplTest {


    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentServiceImpl studentServiceImpl;
    //Write a Junit test case for all methods StudentServiceImpl class


    //Write a Junit test case for addStudent method
    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentName("Name");
        student.setStudentEmail("Email");
        student.setStudentAge(1);
        when(this.studentRepository.save(student)).thenReturn(student);
        Student student1 = this.studentServiceImpl.addStudent(student);
        assertEquals(student, student1);
    }
    //Write a Junit test case for addStudent method
    // where student with same email already exists in database
    // mock findByStudentEmail method
    @Test
    public void testAddStudent1() {
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentName("Name");
        student.setStudentEmail("Email");
        student.setStudentAge(1);
        when(this.studentRepository.findByStudentEmail(student.getStudentEmail())).thenReturn(Optional.of(student));
        when(this.studentRepository.save(student)).thenReturn(student);
        assertThrows(ResponseStatusException.class, () -> this.studentServiceImpl.addStudent(student));
    }


    //Write a Junit test case for addStudent method StudentServiceImpl class
    // student age should be negative
    @Test
    public void testAddStudent2() {
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentName("Name");
        student.setStudentEmail("Email");
        student.setStudentAge(-1);
        when(this.studentRepository.save(student)).thenReturn(student);
        assertThrows(ResponseStatusException.class, () -> this.studentServiceImpl.addStudent(student));
    }


    //Write a Junit test case for updateStudent method  where Student does not exist in the database
    @Test
    public void testUpdateStudent1() {
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentName("Name");
        when(this.studentRepository.save(student)).thenReturn(student);
        assertThrows(ResponseStatusException.class, () -> this.studentServiceImpl.updateStudent(student));
    }

    //Write a Junit test case for updateStudent method  where Student exists in the database
    @Test
    public void testUpdateStudent2() {
        Student student = new Student();
        student.setStudentId(123);
        student.setStudentName("Name");
        when(this.studentRepository.findById(any())).thenReturn(Optional.of(student));
        when(this.studentRepository.save(any())).thenReturn(student);
        Student student1 = this.studentServiceImpl.updateStudent(student);
        assertEquals(student, student1);
    }


    //Write a Junit test case for getStudentById method StudentServiceImpl class

    //Write a Junit test case for deleteStudent method StudentServiceImpl class

    //Write a Junit test case for getAllStudents method StudentServiceImpl class
    //Write a Junit test case for getAllStudents method StudentServiceImpl class

}