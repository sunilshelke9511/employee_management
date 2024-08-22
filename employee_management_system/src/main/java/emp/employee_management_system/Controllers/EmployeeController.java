package emp.employee_management_system.Controllers;

import emp.employee_management_system.dto.requestDto.EmployeeRequestDto;
import emp.employee_management_system.dto.requestDto.UpdateEmplyeeRequestDto;
import emp.employee_management_system.dto.responseDto.EmployeeResponseDto;
import emp.employee_management_system.entity.Employee;
import emp.employee_management_system.exeptions.EmployeeNotFound;
import emp.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
   @Autowired
   EmployeeService employeeService;
   @PostMapping("/add_employee")
   public String  createEmployee(@RequestBody EmployeeRequestDto employeeRequestDto)
   {
      return employeeService.addEmployee(employeeRequestDto);
   }
   @GetMapping ("/getEmployeeById")
   public EmployeeResponseDto getEmployeeByID (@RequestParam("id")int id){
     return employeeService.getEmployeeByID(id);
   }
   @GetMapping("/getAllEmployee")
   public List<Employee> getAllEmployee()
   {
      return employeeService.getAllEmployee();
   }
   @PutMapping ("updateEmployee")
   public EmployeeResponseDto updateEmployee(@RequestBody UpdateEmplyeeRequestDto updateEmplyeeRequestDto)throws EmployeeNotFound
   {
      return employeeService.updateEmployee(updateEmplyeeRequestDto);
   }
   @DeleteMapping("/deleteEmployee")
   public String deleteEmployee(@RequestParam ("id") int id) throws  EmployeeNotFound
   {
      return employeeService.deleteEmplyee(id);
   }

}
