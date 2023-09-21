package com.cts.awspoc.controller;

import com.cts.awspoc.entity.Student;
import com.cts.awspoc.repository.StudentRepository;
import com.cts.awspoc.service.StudentService;
import com.cts.awspoc.service.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {ApplicationContext.class, StudentServiceImpl.class,
        StudentController.class})
@WebMvcTest(excludeAutoConfiguration = {SecurityAutoConfiguration.class})
@TestPropertySources(@TestPropertySource(properties = {"classpath:application.properties"}))
public class StudentControllerTest {

    Student student = new Student();
    @Autowired
    private MockMvc mvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp() {

        student.setStudentId(123);
        student.setStudentName("Name");
        student.setStudentEmail("Email");
        student.setStudentAge(1);
    }

    // Write junit test cases for getAllStudents method in StudentController class and mock studentRepository
    @Test
    public void testGetAllStudents() throws Exception {
        when(studentRepository.findAll()).thenReturn(List.of(student));
        mvc.perform(get("/allstudents")).andExpect(status().isOk());
    }

    // Write junit test cases for getStudentById returning valid value method in StudentController class
    @Test
    public void testGetStudentById() throws Exception {
        when(studentRepository.findById(1)).thenReturn(java.util.Optional.of(student));
        mvc.perform(get("/student/1")).andExpect(status().isOk());
    }

    // Write junit test cases for addStudent method in StudentController class and mock studentRepository
    @Test
    public void testAddStudent() throws Exception {
        when(studentRepository.save(any())).thenReturn(student);
        when(studentRepository.findByStudentEmail(anyString())).thenReturn(Optional.ofNullable(null));
        mvc.perform(post("/addstudent").content(objectMapper.writeValueAsString(student))).andExpect(status().isBadRequest());
    }

    // Write junit test cases for updateStudent method in StudentController class and mock studentRepository
    @Test
    public void testUpdateStudent() throws Exception {
        when(studentRepository.findById(1)).thenReturn(java.util.Optional.of(student));
        mvc.perform(put("/updatestudent/1")).andExpect(status().isOk());
    }


    // Write junit test cases for deleteStudent method in StudentController class and mock studentRepository
    @Test
    public void testDeleteStudent() throws Exception {
        when(studentRepository.findById(1)).thenReturn(java.util.Optional.of(student));
        mvc.perform(delete("/deletestudent/1")).andExpect(status().isOk());
    }

    // Write junit test cases for getStudentById returning valid value method in StudentController class
    @Test
    public void testGetStudentByIdInvalid() throws Exception {
        when(studentRepository.findById(1)).thenReturn(Optional.ofNullable(null));
        mvc.perform(get("/student/1")).andExpect(status().isNotFound());

    }
    // Write junit test cases for getStudentByAge returning valid value method in StudentController class
    @Test
    public void testGetStudentByAge() throws Exception {
        when(studentRepository.findByStudentAge(anyInt())).thenReturn(List.of(student));
        mvc.perform(get("/student/age/1")).andExpect(status().isNotFound());
    }
}