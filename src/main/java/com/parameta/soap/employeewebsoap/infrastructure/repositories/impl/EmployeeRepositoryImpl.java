package com.parameta.soap.employeewebsoap.infrastructure.repositories.impl;

import com.parameta.soap.employeewebsoap.domain.model.employee.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface EmployeeRepositoryImpl extends ReactiveCrudRepository<Employee, String> {
    @Query("INSERT INTO employee() VALUES(:numeroDocumento, :tipoDocumento, :nombre, :apellido, :fechaNacimiento, :fechaVinculacion, :cargo, :salario)")
    public Mono<Employee> saveCustom(String numeroDocumento, String tipoDocumento, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaVinculacion, String cargo, double salario);
}
