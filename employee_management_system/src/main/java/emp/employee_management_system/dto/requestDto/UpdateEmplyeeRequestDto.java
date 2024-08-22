package emp.employee_management_system.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEmplyeeRequestDto {
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
