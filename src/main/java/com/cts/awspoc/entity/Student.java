package com.cts.awspoc.entity;



/*Create an entity class Student with fields studentId,  studentName, studentAge, studentEmail
 Use lombok annotation for constructors,builder, toBuilder is true,getters,setters,toString,equals and hashcode methods.*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_age")
    private Integer studentAge;
    @Column(name = "student_email")
    private String studentEmail;

}
