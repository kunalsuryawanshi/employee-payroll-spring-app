package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To Define Repository
 *
 * @author Kunal Suryawanshi
 * @Since 13-12-2021
 */
public interface EmployeePayrollRepository extends JpaRepository<Employee, Integer> {
}
