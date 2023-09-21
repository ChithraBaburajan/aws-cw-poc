package com.cts.awspoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.awspoc.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//generate code for jpa repository for Student
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //generate Method to get student by Email

    public Optional<Student> findByStudentEmail(String studentEmail);


    //custom query
    public Optional<Student> findByStudentName(String studentName);

    //custom query
    public Student findByStudentNameAndStudentAge(String studentName, int studentAge);

    //custom query
    public Student findByStudentNameOrStudentAge(String studentName, int studentAge);

    //custom query
    public Student findByStudentNameAndStudentAgeGreaterThan(String studentName, int studentAge);

    //custom query
    public Student findByStudentNameAndStudentAgeLessThan(String studentName, int studentAge);

    //generate MySQL query for deleting student by student id
    @Query(value = "delete from student where student_id = ?", nativeQuery = true)
    @Modifying
    public Student deleteByStudentId(int studentId);

    List<Student> findByStudentAge(int age);

    //Generate JPQL query for finding students between age1 and age2
    @Query(value = "select s from Student s where s.studentAge between ?1 and ?2")
    List<Student> getStudentsByAgeBetween(int age1, int age2);


    List<Student> findByStudentAgeBetween(int age1, int age2);

}