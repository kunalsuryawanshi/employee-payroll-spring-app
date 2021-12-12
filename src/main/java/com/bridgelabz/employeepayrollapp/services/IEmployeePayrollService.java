package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.models.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeeDto> getAllEmployee();

    Employee getEmployeeById(int empId);

    Employee addEmployee(EmployeeDto empPayrollDto);

    Employee updateEmployee(int id, EmployeeDto employeeDto);

    String deleteEmployee(int empId);

}