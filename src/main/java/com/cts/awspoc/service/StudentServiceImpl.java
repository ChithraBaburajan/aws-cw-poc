package com.cts.awspoc.service;
//Implement the StudentService interface in this StudentServiceImpl class.

import com.cts.awspoc.entity.Student;

import java.util.List;
import java.util.Optional;

import com.cts.awspoc.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

//add required imports to compile
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        //If id is less than or equal to 0 throw ResponseStatusException with code BAD_REQUEST and message Invalid Student Id
        if (id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Student Id");
        }
        return studentRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist!"));
    }

    @Override
    public Student addStudent(Student student) {
        validateStudentDetails(student);
        Optional<Student> existingStudent = studentRepository.findByStudentEmail(student.getStudentEmail());
        if (existingStudent.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student already Exists");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        /*if Student does not exist in repository is not null then
        throw ResponseStatusException with code BAD_REQUEST and message Student already Exists
         */
        Student existingStudent = getStudentById(student.getStudentId());

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
         /*If Student does not exist in studentRepository is not null then
        throw ResponseStatusException with code BAD_REQUEST and message Student already Exists
         */

        Student existingStudent =
                studentRepository.findById(studentId).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student does not exist!"));

        studentRepository.deleteById(studentId);
    }


    @Override
    public Student getStudentByName(String name) {

        return studentRepository.findByStudentName(name).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student does not exist!")
        );
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByStudentEmail(email).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist!")
        );
    }

    @Override
    public List<Student> getStudentsByAge(int age) {
        return studentRepository.findByStudentAge(age);
    }

    @Override
    public List<Student> getStudentsByAgeBetween(int age1, int age2) {
        return studentRepository.findByStudentAgeBetween(age1, age2);
    }

    //Add method to validateStudentDetails
    public void validateStudentDetails(Student student) {

        if (student.getStudentName() == null || student.getStudentName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Name cannot be empty");
        }
        if (student.getStudentEmail() == null || student.getStudentEmail().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Email cannot be empty");
        }
        if (student.getStudentAge() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student Age cannot be 0 or less than 0");
        }

    }

}


