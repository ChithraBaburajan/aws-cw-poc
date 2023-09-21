package com.cts.awspoc.entity;

import static org.junit.jupiter.api.Assertions.*;

import com.cts.awspoc.entity.Student;
import org.junit.jupiter.api.Test;

//Write a Junit test case for Student class.
//Create a Student class with the following attributes:
//studentId,  studentName, studentAge, studentEmail

/*
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private String studentEmail;
}
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer studentId;
    private String studentName;
    private Integer studentAge;
    private String studentEmail;
 */
//Create a parameterized constructor to initialize the attributes.
//Create a getter and setter methods for the attributes.
//Create a test case for Student class.
//Create a StudentTest class with the following test cases:
//Write a junit test case to test the setter and getter methods of Student class.
//Write a junit test case to test the parameterized constructor of Student class.
//Write a junit test case to test the no arguments constructor of Student class.
//Write a junit test case to test the toString method of Student class.
//Write a junit test case to test the equals and hashcode method of Student class.
//Write a junit test case to test the builder method of Student class.
//Run the test cases and check the results.

class StudentTest {
    @Test
    void testStudent() {
        Student student = new Student(1, "Raj", 23, "XXXXXXXXXXXXX");
        assertEquals(1, student.getStudentId());
        assertEquals("Raj", student.getStudentName());
        assertEquals(23, student.getStudentAge());
        assertEquals("XXXXXXXXXXXXX", student.getStudentEmail());
    }

    @Test
    void testStudentToString() {
        Student student = new Student(1, "Raj", 23, "XXXXXXXXXXXXX");
        assertEquals("Student(studentId=1, studentName=Raj, studentAge=23, studentEmail=XXXXXXXXXXXXX)", student.toString());
    }

    @Test
    void testStudentEqualsAndHashCode() {

        Student student1 = new Student(1, "Raj", 23, "XXXXXXXXXXXXX");
        Student student2 = new Student(1, "Raj", 23, "XXXXXXXXXXXXX");
        Student student3 = new Student(2, "Raj", 23, "XXXXXXXXXXXXX");
        assertEquals(student1, student2);
        assertNotEquals(student1, student3);
        assertNotEquals(student1.hashCode(), student3.hashCode());
    }

    @Test
    void testStudentNoArgConstructor() {
        Student student = new Student();
        assertEquals(null, student.getStudentId());
        assertEquals(null, student.getStudentName());
        assertEquals(null, student.getStudentAge());
        assertEquals(null, student.getStudentEmail());
    }


    @Test
    void testStudentSetterGetter() {
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("Raj");
        student.setStudentAge(23);
        student.setStudentEmail("XXXXXXXXXXXXX");
        assertEquals(1, student.getStudentId());
        assertEquals("Raj", student.getStudentName());
        assertEquals(23, student.getStudentAge());
        assertEquals("XXXXXXXXXXXXX", student.getStudentEmail());
    }
    @Test
    void testStudentBuilder() {
        Student student = Student.builder().studentId(1).studentName("Raj").studentAge(23).studentEmail("XXXXXXXXXXXXX").build();
        assertEquals(1, student.getStudentId());
        assertEquals("Raj", student.getStudentName());

        assertEquals(23, student.getStudentAge());

        assertEquals("XXXXXXXXXXXXX", student.getStudentEmail());
    }
    @Test
    void testStudentBuilderWithNoArgs() {
        Student student = Student.builder().build();
        assertEquals(null, student.getStudentId());
        assertEquals(null, student.getStudentName());
        assertEquals(null, student.getStudentAge());
        assertEquals(null, student.getStudentEmail());
        assertEquals("Student(studentId=null, studentName=null, studentAge=null, studentEmail=null)", student.toString());
    }
    @Test
    void testStudentBuilderWithNullArgs() {
        Student student = Student.builder().studentId(null).studentName(null).studentAge(null).studentEmail(null).build();
        assertEquals(null, student.getStudentId());
        assertEquals(null, student.getStudentName());
        assertEquals(null, student.getStudentAge());
        assertEquals(null, student.getStudentEmail());
        assertEquals("Student(studentId=null, studentName=null, studentAge=null, studentEmail=null)", student.toString());
    }

}