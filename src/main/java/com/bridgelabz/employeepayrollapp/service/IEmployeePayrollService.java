package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.models.Employee;

import java.util.List;

/**
 * Purpose To Create Interface Class For Payroll Service
 *
 * @author : Kunal Suryawanshi
 * @since : 13-12-2021
 */
public interface IEmployeePayrollService {
    List<EmployeeDto> getAllEmployee();

    EmployeeDto getEmployeeById(int empId);

    String addEmployee(EmployeeDto empPayrollDTO);

    String updateEmployee(int id, EmployeeDto employeeDto);

    String deleteEmployee(int empId);

    Employee checkIdPresentOrNot(int empId);
}
