/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeH2Service;

@RestController
public class EmployeeController {
  @Autowired
  public EmployeeH2Service a;

  @GetMapping("/employees")
  public ArrayList<Employee> getallemployee() {
    return a.getallemployee();
  }

  @PostMapping("/employees")
  public Employee addnewemployee(@RequestBody Employee bodycontentp) {

   return  a.addnewemployee(bodycontentp);
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getparticularemployee(@PathVariable("employeeId") int employeeId) {
    return a.getparticularemployee(employeeId);
  }

  @PutMapping("/employees/{employeeId}")
  public Employee updateemployee(@PathVariable("employeeId") int employeeId, @RequestBody Employee bodymatched) {
    return a.updateemployee(employeeId, bodymatched);
  }

  @DeleteMapping("/employees/{employeeId}")
  public void deleteemployee(@PathVariable("employeeId") int employeeId) {
    a.deleteemployee(employeeId);
  }
}
