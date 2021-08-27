package com.parameta.soap.employeewebsoap.infrastructure.endpoint.helpers;

import org.springframework.schema.web_services.Employee;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class EntityModelHelper {

    public static Employee createResponse(com.parameta.soap.employeewebsoap.domain.model.employee.Employee employee){

        Employee emp = new Employee();
        emp.setNumeroDocumento(employee.getNumeroDocumento());
        emp.setTipoDocumento(employee.getTipoDocumento());
        emp.setNombre(employee.getNombre());
        emp.setApellido(emp.getApellido());
        emp.setFechaNacimiento(toXMLGregorianCalendar(new Date()));
        emp.setFechaVinculacion(toXMLGregorianCalendar(new Date()));
        emp.setCargo(employee.getCargo());
        emp.setSalario(employee.getSalario());
        return emp;
    }

    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date)
    {
        GregorianCalendar gCalendar
                = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar
                    = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gCalendar);
        }
        catch (DatatypeConfigurationException ex) {
            System.out.println(ex);
        }
        return xmlCalendar;
    }

    public static LocalDate toLocalDate(XMLGregorianCalendar xmlGregorianCalendar){
         LocalDate localDate = LocalDate.of(
                xmlGregorianCalendar.getYear(),
                xmlGregorianCalendar.getMonth(),
                xmlGregorianCalendar.getDay());
        return localDate;
    }
}
