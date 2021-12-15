package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Purpose: To Get Data From End User
 *
 * @author : Kunal Suryawanshi
 * @since : 13-12-2021
 */
@Data
public class EmployeeDto {
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}([\\s][A-Z]{1}[a-z]{2,})?$", message = "Minimum 3 Characters and First Letter Should be Capital")
    private String name;

    @NotNull
    private String imagePath;

    @NotNull
    @Pattern(regexp = "(m|M|male|Male|f|F|female|Female)", message = "Gender Should be Male or Female")
    private String gender;

    @NotNull
    private String salary;

    @NotNull
    private String department;

    @NotNull
    private String notes;
}