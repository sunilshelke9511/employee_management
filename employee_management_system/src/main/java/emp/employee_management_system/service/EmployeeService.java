package emp.employee_management_system.service;

import emp.employee_management_system.dto.requestDto.EmployeeRequestDto;
import emp.employee_management_system.dto.requestDto.UpdateEmplyeeRequestDto;
import emp.employee_management_system.dto.responseDto.EmployeeResponseDto;
import emp.employee_management_system.entity.Employee;
import emp.employee_management_system.exeptions.EmployeeNotFound;

import java.util.List;

public interface EmployeeService {
    public String addEmployee(EmployeeRequestDto employeeRequestDto);

    public EmployeeResponseDto getEmployeeByID(int id);
    List<Employee> getAllEmployee();
    public EmployeeResponseDto updateEmployee(UpdateEmplyeeRequestDto updateEmplyeeRequestDto)throws EmployeeNotFound;
    public String deleteEmplyee (int id)throws EmployeeNotFound;
}
