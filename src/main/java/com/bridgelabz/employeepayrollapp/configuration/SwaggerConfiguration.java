package com.bridgelabz.employeepayrollapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Purpose: To Configure Swagger
 *
 * @author: Kunal Suryawanshi
 * @since: 13-12-2021
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Employee Payroll App")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.employeepayrollapp.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Payroll Application")
                .description("Sample Documentation Generated Using SWAGGER2 for Employee Payroll Rest API")
                .termsOfServiceUrl("https://github.com/kunalsuryawanshi")
                .license("License")
                .licenseUrl("https://github.com/kunalsuryawanshi")
                .version("1.0")
                .build();
    }
}