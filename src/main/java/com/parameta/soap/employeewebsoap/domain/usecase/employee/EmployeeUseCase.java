package com.parameta.soap.employeewebsoap.domain.usecase.employee;

import com.parameta.soap.employeewebsoap.domain.model.employee.Employee;
import com.parameta.soap.employeewebsoap.domain.model.employee.gateway.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public void save(Employee employee){
          employeeRepository.save(employee);
    }
}
