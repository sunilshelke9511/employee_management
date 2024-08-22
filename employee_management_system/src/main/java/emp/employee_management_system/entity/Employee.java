package emp.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String firstName;
    private  String middleName;
    private  String lastName;

    private Date joiningDate;

    private  String designation;

    private  String previousDesignation;

    private String qualification;

    private int salary;


}
