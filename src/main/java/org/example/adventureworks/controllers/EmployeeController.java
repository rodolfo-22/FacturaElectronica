package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.employee.EmployeeCreateRequest;
import org.example.adventureworks.models.dto.Request.employee.EmployeeUpdateRequest;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.models.dto.Response.employee.EmployeeResponse;
import org.example.adventureworks.service.EmployeeService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/new-employee")
    public ResponseEntity<GeneralResponse> NewEmployee(@Valid @RequestBody EmployeeCreateRequest customer) {
        EmployeeResponse employeeCreated = employeeService.save(customer);
        return ResponseBuilderUtil.buildResponse("Empleado creado correctamente", HttpStatus.CREATED, employeeCreated);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/by-email/{email}")
    public ResponseEntity<GeneralResponse> getEmployeeByEmail(@PathVariable String email) {
        EmployeeResponse employee = employeeService.getByEmail(email);
        return ResponseBuilderUtil.buildResponse("Empleado encontrado", HttpStatus.OK, employee);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update-employee")
    public ResponseEntity<GeneralResponse> updateEmployee(@Valid @RequestBody EmployeeUpdateRequest employee) {
        EmployeeResponse updatedEmployee = employeeService.update(employee);
        return ResponseBuilderUtil.buildResponse("Empleado actualizado correctamente", HttpStatus.OK, updatedEmployee);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<GeneralResponse> deleteEmployee(@PathVariable String email) {
        String message = employeeService.delete(email);
        return ResponseBuilderUtil.buildResponse(message, HttpStatus.OK, null);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/all-employees" )
    public ResponseEntity<GeneralResponse> getAllEmployees() {
        return ResponseBuilderUtil.buildResponse("Lista de empleados", HttpStatus.OK, employeeService.getAll());
    }
}
