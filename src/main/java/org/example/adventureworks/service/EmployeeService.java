package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.employee.EmployeeCreateRequest;
import org.example.adventureworks.models.dto.Request.employee.EmployeeUpdateRequest;
import org.example.adventureworks.models.dto.Response.employee.EmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeResponse save(EmployeeCreateRequest request);
    EmployeeResponse getByEmail(String email);
    EmployeeResponse update(EmployeeUpdateRequest request);
    String delete(String email);
    List<EmployeeResponse> getAll();
}
