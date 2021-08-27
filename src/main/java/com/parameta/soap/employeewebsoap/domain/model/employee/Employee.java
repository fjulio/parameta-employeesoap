package com.parameta.soap.employeewebsoap.domain.model.employee;

import lombok.*;
import org.springframework.data.annotation.Id;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@Table("employee")
public class Employee implements Persistable<Integer> {

    @Id
    private Integer id;
    private String numeroDocumento;
    private String tipoDocumento;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private LocalDate fechaVinculacion;
    private String cargo;
    private double salario;

    @Transient
    private boolean newProduct;

    @Override
    @Transient
    public boolean isNew() {
        return this.newProduct || id == null;
    }

    public Employee setAsNew(){
        this.newProduct = true;
        return this;
    }
}
