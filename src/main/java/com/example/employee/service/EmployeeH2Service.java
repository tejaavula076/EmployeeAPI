/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.model.EmployeeRowMapper;

@Service
public class EmployeeH2Service implements EmployeeRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Employee> getallemployee() {
        List<Employee> aone = db.query("select * from EMPLOYEELIST ", new EmployeeRowMapper());
        ArrayList<Employee> bone = new ArrayList<>(aone);
        return bone;
    }

    @Override
    public Employee addnewemployee(Employee bodycontentp) {
        db.update("insert into EMPLOYEELIST(employeeName,email,department) values(?,?,?) ",
                bodycontentp.getEmployeeName(), bodycontentp.getDepartment(), bodycontentp.getDepartment());
        Employee onef = db.queryForObject("select * from EMPLOYEELIST where employeeName=? and email=?",
                new EmployeeRowMapper(), bodycontentp.getEmployeeName(), bodycontentp.getDepartment());
        return onef;

    }

    @Override
    public Employee getparticularemployee(int employeeId) {
        try {
            Employee chedf = db.queryForObject("select * from EMPLOYEELIST where employeeId=?", new EmployeeRowMapper(),employeeId);
            return chedf;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Employee updateemployee(int employeeId, Employee bodymatched) {
        if (bodymatched.getEmployeeName() != null) {
            db.update("update EMPLOYEELIST set  employeeName=? where employeeId=?", bodymatched.getEmployeeName(),
                    employeeId);
        }
        if (bodymatched.getEmail() != null) {
            db.update("update EMPLOYEELIST set  email=? where employeeId=?", bodymatched.getEmail(),
                    employeeId);
        }
        if (bodymatched.getDepartment() != null) {
            db.update("update EMPLOYEELIST set  department=? where employeeId=?", bodymatched.getDepartment(),
                    employeeId);
        }
        return getparticularemployee(employeeId);
    }

    @Override
    public void deleteemployee(int employeeId) {
        db.update("delete from EMPLOYEELIST where employeeId=? ", employeeId);
    };

}
