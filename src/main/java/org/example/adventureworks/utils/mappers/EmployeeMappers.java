package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.employee.EmployeeCreateRequest;
import org.example.adventureworks.models.dto.Request.employee.EmployeeUpdateRequest;
import org.example.adventureworks.models.dto.Response.employee.EmployeeResponse;
import org.example.adventureworks.models.entities.Employees;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMappers {

    //Comvirtiendo EmployeeCreateRequest a Employee
    public static Employees ToEntityCreate(EmployeeCreateRequest customerRequest){
        return Employees.builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .phone(customerRequest.getPhone())
                .build();
    }

    //Convertir Employees a EmployeeResponse
    public static EmployeeResponse ToDTO(Employees employee){
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .email(employee.getEmail())
                .address(employee.getAddress())
                .phone(employee.getPhone())
                .build();
    }

    //Para modificar un empleado, convertir EmployeeUpdateRequest a Employees
    public static Employees ToEntityUpdate(EmployeeUpdateRequest updatedEmployee){
        return Employees.builder()
                .id(updatedEmployee.getId())
                .name(updatedEmployee.getName())
                .surname(updatedEmployee.getSurname())
                .email(updatedEmployee.getEmail())
                .address(updatedEmployee.getAddress())
                .phone(updatedEmployee.getPhone())
                .build();
    }

    //Consultando todos los empleados
    public static List<EmployeeResponse> toDTOList(List<Employees> allEmployees) {
        return allEmployees.stream().map(EmployeeMappers::ToDTO).collect(Collectors.toList());
    }
}
