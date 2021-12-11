package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<Employee, Integer> {
}
