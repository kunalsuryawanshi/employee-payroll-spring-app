package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose: to demonstrate different http methods
 *
 * @author : Kunal Suryawanshi
 * @since : 13-12-2021
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * Purpose : to gives us list of all employee from repo
     *
     * @return : list of all employee
     */
    @RequestMapping(value = {"", "/", "/employee"})
    public List<EmployeeDto> getEmployeePayrollData() {
        return employeePayrollService.getAllEmployee();
    }

    /**
     * Purpose : To Get employee From id
     *
     * @param empId to find this id in repo
     * @return dto of given id
     */
    @GetMapping("/employee/{empId}")
    public EmployeeDto getEmployeePayrollData(@PathVariable("empId") int empId) {
        return employeePayrollService.getEmployeeById(empId);
    }

    /**
     * Purpose : To Add employee in Repo
     *
     * @param employeeDto : this metadata gets added to repo
     * @return : success message for add
     */
    @PostMapping("/employee")
    public String addEmployeePayrollData(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeePayrollService.addEmployee(employeeDto);
    }

    /**
     * Purpose : To Edit Existing Employee
     *
     * @param id          for search data in repo
     * @param employeeDto for changing existing data to new
     * @return success message for update
     */
    @PutMapping("/employee/{id}")
    public String updateEmployeePayrollData(@PathVariable(value = "id") int id,
                                            @Valid @RequestBody EmployeeDto employeeDto) {
        return employeePayrollService.updateEmployee(id, employeeDto);
    }

    /**
     * Purpose : To Delete Existing Employee
     *
     * @param id For Search in repo
     * @return success message for delete
     */
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeePayrollData(@PathVariable("id") int id) {
        return employeePayrollService.deleteEmployee(id);
    }
}
