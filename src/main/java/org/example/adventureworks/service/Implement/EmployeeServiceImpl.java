package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.models.dto.Request.employee.EmployeeCreateRequest;
import org.example.adventureworks.models.dto.Request.employee.EmployeeUpdateRequest;
import org.example.adventureworks.models.dto.Response.employee.EmployeeResponse;
import org.example.adventureworks.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeService employeeService;

    @Override
    public EmployeeResponse save(EmployeeCreateRequest request) {

        return null;
    }

    @Override
    public EmployeeResponse getById(Long id) {
        return null;
    }

    @Override
    public EmployeeResponse update(EmployeeUpdateRequest request) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return "";
    }

    @Override
    public List<EmployeeResponse> getAll() {
        return List.of();
    }
}
