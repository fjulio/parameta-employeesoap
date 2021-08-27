package com.parameta.soap.employeewebsoap.domain.model.employee.gateway;

import com.parameta.soap.employeewebsoap.domain.model.employee.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeRepository {
    public void save(Employee employee);
}
