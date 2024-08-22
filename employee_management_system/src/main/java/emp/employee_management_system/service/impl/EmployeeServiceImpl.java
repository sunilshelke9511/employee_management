package emp.employee_management_system.service.impl;

import emp.employee_management_system.dto.requestDto.EmployeeRequestDto;
import emp.employee_management_system.dto.requestDto.UpdateEmplyeeRequestDto;
import emp.employee_management_system.dto.responseDto.EmployeeResponseDto;
import emp.employee_management_system.entity.Employee;
import emp.employee_management_system.exeptions.EmployeeNotFound;
import emp.employee_management_system.repository.EmployeeRepository;
import emp.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class    EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public String addEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee=new Employee();
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setMiddleName(employeeRequestDto.getMiddleName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setJoiningDate(employeeRequestDto.getJoiningDate());
        employee.setDesignation(employeeRequestDto.getDesignation());
        employee.setSalary(employee.getSalary());
        employee.setPreviousDesignation(employeeRequestDto.getPreviousDesignation());
        employee.setQualification(employeeRequestDto.getQualification());

        employeeRepository.save(employee);
        return "employee added";
    }

    @Override
    public EmployeeResponseDto getEmployeeByID(int id) {
       // return employeeRepository.findById(id).get();
        Employee employee =employeeRepository.findById(id).get();
        EmployeeResponseDto employeeResponseDto =new EmployeeResponseDto();

        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setMiddleName(employee.getMiddleName());
        employeeResponseDto.setLastName(employee.getLastName());
        employeeResponseDto.setJoiningDate(employee.getJoiningDate());
        employeeResponseDto.setDesignation(employee.getDesignation());
        employeeResponseDto.setPreviousDesignation(employee.getPreviousDesignation());
        employeeResponseDto.setQualification(employee.getQualification());
        employeeResponseDto.setSalary(employee.getSalary());

        return  employeeResponseDto;


    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeesList=employeeRepository.findAll();
        return employeesList;
    }

    @Override
    public EmployeeResponseDto updateEmployee(UpdateEmplyeeRequestDto updateEmplyeeRequestDto) throws EmployeeNotFound {
        try {
            Employee employee=employeeRepository.findById(updateEmplyeeRequestDto.getId()).get();
            employee.setFirstName(updateEmplyeeRequestDto.getFirstName());
            employee.setMiddleName(updateEmplyeeRequestDto.getMiddleName());
            employee.setLastName(updateEmplyeeRequestDto.getLastName());
            employee.setJoiningDate(updateEmplyeeRequestDto.getJoiningDate());
            employee.setQualification(updateEmplyeeRequestDto.getQualification());
            employee.setDesignation(updateEmplyeeRequestDto.getDesignation());
            employee.setPreviousDesignation(updateEmplyeeRequestDto.getPreviousDesignation());
            employee.setSalary(updateEmplyeeRequestDto.getSalary());
            employeeRepository.save(employee);

            // prepare response dto
            EmployeeResponseDto employeeResponseDto =new EmployeeResponseDto();

            employeeResponseDto.setId(updateEmplyeeRequestDto.getId());
            employeeResponseDto.setFirstName(employee.getFirstName());
            employeeResponseDto.setMiddleName(employee.getMiddleName());
            employeeResponseDto.setLastName(employee.getLastName());
            employeeResponseDto.setJoiningDate(employee.getJoiningDate());
            employeeResponseDto.setQualification(employee.getQualification());
            employeeResponseDto.setDesignation(employee.getDesignation());
            employeeResponseDto.setPreviousDesignation(employee.getPreviousDesignation());
            employeeResponseDto.setSalary(employee.getSalary());

            return employeeResponseDto;

        }
        catch (Exception e)
        {
            throw  new EmployeeNotFound("Employee not available");
        }

    }

    @Override
    public String deleteEmplyee(int id) throws EmployeeNotFound {
        try
        {
            employeeRepository.deleteById(id);
            return "employee deleted";
        }
        catch (Exception e)
        {
            throw  new EmployeeNotFound("Student not available");
        }
    }

}
