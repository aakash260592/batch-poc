package com.jcs.batch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class EmployeeDTO {

    @Id
    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String hireDate;
    private String jobId;
    private String salary;
    private Double newSalary;
}
