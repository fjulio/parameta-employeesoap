package com.parameta.soap.employeewebsoap.infrastructure.configuration;

import com.parameta.soap.employeewebsoap.domain.model.employee.gateway.EmployeeRepository;
import com.parameta.soap.employeewebsoap.domain.usecase.employee.EmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public EmployeeUseCase employeeUseCase(EmployeeRepository employeeRepository){
        return new EmployeeUseCase(employeeRepository);
    }

}
