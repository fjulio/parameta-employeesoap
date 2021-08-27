package com.parameta.soap.employeewebsoap.application.adapter;

import com.parameta.soap.employeewebsoap.domain.model.employee.Employee;
import com.parameta.soap.employeewebsoap.domain.model.employee.gateway.EmployeeRepository;
import com.parameta.soap.employeewebsoap.infrastructure.repositories.impl.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EmployeeAdapter implements EmployeeRepository {

    @Autowired
    EmployeeRepositoryImpl employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee).subscribe();
    }
}
