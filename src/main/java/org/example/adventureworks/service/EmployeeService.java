package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.employee.EmployeeCreateRequest;
import org.example.adventureworks.models.dto.Request.employee.EmployeeUpdateRequest;
import org.example.adventureworks.models.dto.Response.employee.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse save(EmployeeCreateRequest request);
    EmployeeResponse getById(Long id);
    EmployeeResponse update(EmployeeUpdateRequest request);
    String delete(Long id);
    List<EmployeeResponse> getAll();
}
