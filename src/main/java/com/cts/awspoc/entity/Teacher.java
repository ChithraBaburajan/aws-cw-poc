package com.cts.awspoc.entity;
//Generate a Teacher Entity class for table teacher with fields teacherId,  teacherName, teacherEmail, teacherSalary
//Use lombok annotation for constructors,builder, toBuilder is true,getters,setters,toString,equals and hashcode methods.
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "teacher_email")
    private String teacherEmail;
    @Column(name = "teacher_salary")
    private Double teacherSalary;

}

