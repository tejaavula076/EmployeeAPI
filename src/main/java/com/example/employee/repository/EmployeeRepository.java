// Write your code here
package com.example.employee.repository;
import java.util.*;
import com.example.employee.model.Employee;
public interface EmployeeRepository{
    ArrayList<Employee> getallemployee();
    Employee addnewemployee( Employee bodycontentp);
    Employee getparticularemployee(int employeeId);
    Employee updateemployee(int employeeId,Employee bodymatched);
    void deleteemployee(int employeeId);

}