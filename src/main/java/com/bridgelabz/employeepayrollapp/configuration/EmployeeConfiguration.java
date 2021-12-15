package com.bridgelabz.employeepayrollapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose: to configure model mapper
 *
 * @author: Kunal Suryawanshi
 * @since: 13-12-2021
 */
@Configuration
public class EmployeeConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
