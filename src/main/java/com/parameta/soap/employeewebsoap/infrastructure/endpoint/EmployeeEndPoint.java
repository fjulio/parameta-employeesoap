package com.parameta.soap.employeewebsoap.infrastructure.endpoint;

import com.parameta.soap.employeewebsoap.domain.model.employee.Employee;
import com.parameta.soap.employeewebsoap.domain.usecase.employee.EmployeeUseCase;
import com.parameta.soap.employeewebsoap.infrastructure.endpoint.helpers.EntityModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.schema.web_services.SaveEmployeeRequest;
import org.springframework.schema.web_services.SaveEmployeeResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import reactor.core.publisher.Mono;

@Endpoint
public class EmployeeEndPoint {

    private static final String NAMESPACE_URI = "http://www.springframework.org/schema/web-services";

    private EmployeeUseCase employeeUseCase;

    @Autowired
    public  EmployeeEndPoint(EmployeeUseCase employeeUseCase){
        this.employeeUseCase = employeeUseCase;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveEmployeeRequest")
    @ResponsePayload
    public SaveEmployeeResponse saveEmployee(@RequestPayload SaveEmployeeRequest request){
        SaveEmployeeResponse response = new SaveEmployeeResponse();
         employeeUseCase.save(Employee.builder()
                        .numeroDocumento(request.getEmployee().getNumeroDocumento())
                        .tipoDocumento(request.getEmployee().getTipoDocumento())
                        .nombre(request.getEmployee().getNombre())
                        .apellido(request.getEmployee().getApellido())
                        .fechaNacimiento(EntityModelHelper.toLocalDate(request.getEmployee().getFechaNacimiento()))
                        .fechaVinculacion(EntityModelHelper.toLocalDate(request.getEmployee().getFechaVinculacion()))
                        .cargo(request.getEmployee().getCargo())
                        .salario(request.getEmployee().getSalario())
                .build());
         response.setEmployee(request.getEmployee());
         return response;
    }

}
