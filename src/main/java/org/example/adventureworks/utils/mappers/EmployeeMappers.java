package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.employee.EmployeeCreateRequest;
import org.example.adventureworks.models.dto.Request.employee.EmployeeUpdateRequest;
import org.example.adventureworks.models.dto.Response.employee.EmployeeResponse;
import org.example.adventureworks.models.dto.Response.role.RoleResponse;
import org.example.adventureworks.models.entities.Employees;
import org.example.adventureworks.models.entities.Role;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMappers {

    //Comvirtiendo EmployeeCreateRequest a Employee
    public static Employees ToEntityCreate(EmployeeCreateRequest customerRequest, Role role) {
        return Employees.builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .password(customerRequest.getPassword())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .phone(customerRequest.getPhone())
                .roles(role)
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
                .role(employee.getRoles().getRole())
                .build();
    }

    //Para modificar un empleado, convertir EmployeeUpdateRequest a Employees
    public static Employees ToEntityUpdate(EmployeeUpdateRequest updatedEmployee,Role role) {
        return Employees.builder()
                .id(updatedEmployee.getId())
                .name(updatedEmployee.getName())
                .surname(updatedEmployee.getSurname())
                .password(updatedEmployee.getPassword())
                .email(updatedEmployee.getEmail())
                .address(updatedEmployee.getAddress())
                .phone(updatedEmployee.getPhone())
                .roles(role)
                .build();
    }

    //Consultando todos los empleados
    public static List<EmployeeResponse> ToDTOList(List<Employees> allEmployees) {
        return allEmployees.stream().map(EmployeeMappers::ToDTO).collect(Collectors.toList());
    }
}
