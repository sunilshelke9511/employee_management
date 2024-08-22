package emp.employee_management_system.dto.responseDto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponseDto {

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
