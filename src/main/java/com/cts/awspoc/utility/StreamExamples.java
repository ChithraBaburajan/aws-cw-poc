package com.cts.awspoc.utility;

import lombok.Getter;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Getter
class Employee {
    Integer empId;
    String empName;
    Long salary;
    String email;
    Department department;

    Employee(Integer empId,
             String empName,
             Long salary,
             String email,
             Department department) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.email = email;
        this.department = department;
    }
}

@Getter
class Department {
    Integer deptId;
    String department;

    Department(Integer deptId,
               String department) {
        this.deptId = deptId;
        this.department = department;
    }
}

public class StreamExamples {

    public static void main(String args[]) {
        Department hrDept = new Department(1, "HR");
        Department corpDept = new Department(2, "CORP");
        Department itDept = new Department(3, "IT");
        Department markDept = new Department(3, "MKT");
        Map<Integer, Employee> empMap = new HashMap<>();
        empMap.put(1, new Employee(1, "Harsh", 1000L, "Harsh@gmail.com", hrDept));
        empMap.put(2, new Employee(2, "Harshita", 2000L, "Harshitha@gmail.com", hrDept));
        empMap.put(3, new Employee(3, "Harshad", 1000L, "Harshad@gmail.com", hrDept));
        empMap.put(4, new Employee(4, "Harshneeta", 4000L, "Harshneeta@gmail.com", hrDept));
        empMap.put(5, new Employee(5, "Harshal", 2000L, "Harshal@gmail.com", hrDept));
        empMap.put(6, new Employee(6, "Harshali", 3000L, "Harshali@gmail.com", hrDept));
        empMap.put(11, new Employee(11, "Harshi", 1000L, "Harsh@gmail.com", corpDept));
        empMap.put(12, new Employee(12, "Harshita", 2000L, "Harshitha@gmail.com", corpDept));
        empMap.put(13, new Employee(13, "Harshad", 1000L, "Harshad@gmail.com", corpDept));
        empMap.put(14, new Employee(14, "Harshneeta", 4000L, "Harshneeta@gmail.com", itDept));
        empMap.put(15, new Employee(15, "Harshal", 2000L, "Harshal@gmail.com", itDept));
        empMap.put(16, new Employee(16, "Harshali", 3000L, "Harshali@gmail.com", itDept));
        highestSalaryInEachDepartment(empMap);
    }

    // Find the  highest salary paid  in each department for all departments
    public static void highestSalaryInEachDepartment(Map<Integer, Employee> empMap) {
        empMap.values().stream()
                .collect(groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .forEach((k, v) -> System.out.println("Highest salary in " + k.department + " is " + v.get().getSalary()));

    }
}
