package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.configuration.AtmConfiguration;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import com.bridgelabz.employeepayrollapp.models.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private static final String EMPLOYEE_DELETED_SUCCESSFULLY = "Employee Deleted Successfully";

    @Autowired
    private EmployeePayrollRepository employeeRepo;
    @Autowired
    private AtmConfiguration atmConfiguration;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepo.findAll()
                .stream()
                .map(Employee -> modelMapper.map(Employee, EmployeeDto.class))
                .collect((Collectors.toList()));
    }

    @Override
    public Employee getEmployeeById(int empId) {
        checkIdPresentOrNot(empId);
        return employeeRepo.findById(empId).get();
    }

    @Override
    public Employee addEmployee(EmployeeDto empPayrollDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(empPayrollDTO, employee);
        employeeRepo.save(employee);
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(int id, EmployeeDto employeeDto) {
        Employee employee = checkIdPresentOrNot(id);
        BeanUtils.copyProperties(employeeDto, employee);
        return employeeRepo.save(employee);
    }

    public String deleteEmployee(int empId) {
        Employee employee = checkIdPresentOrNot(empId);
        employeeRepo.delete(employee);
        return EMPLOYEE_DELETED_SUCCESSFULLY;
    }

    public Employee checkIdPresentOrNot(int empId) {
        return employeeRepo.findById(empId).orElseThrow(EntityNotFoundException::new);
    }
}
