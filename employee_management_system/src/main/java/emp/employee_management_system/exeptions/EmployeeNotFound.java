package emp.employee_management_system.exeptions;

import org.apache.logging.log4j.message.Message;

public class EmployeeNotFound extends Exception{
    public EmployeeNotFound(String message)
    {
        super(message);
    }
}
