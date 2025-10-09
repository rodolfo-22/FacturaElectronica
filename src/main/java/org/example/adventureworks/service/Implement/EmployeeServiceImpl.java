package org.example.adventureworks.service.Implement;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.adventureworks.exceptions.EmployeeNotFoundException;
import org.example.adventureworks.models.dto.Request.employee.EmployeeCreateRequest;
import org.example.adventureworks.models.dto.Request.employee.EmployeeUpdateRequest;
import org.example.adventureworks.models.dto.Response.employee.EmployeeResponse;
import org.example.adventureworks.models.entities.Employees;
import org.example.adventureworks.models.entities.Role;
import org.example.adventureworks.repository.EmployeeRepository;
import org.example.adventureworks.service.EmployeeService;
import org.example.adventureworks.service.RoleService;
import org.example.adventureworks.utils.mappers.EmployeeMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleService roleService;

    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Override
    @Transactional // Asegura que la operación de guardado sea atómica, es decir, se completa en su totalidad o no se realiza.
    // Si ocurre algún error durante el proceso, la transacción se revertirá.
    public EmployeeResponse save(EmployeeCreateRequest request) {

        if (employeeRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está en uso");
        }

        Role role = roleService.findRoleEntityByName(request.getRole());

        // Aquí encriptamos la contraseña ANTES de guardarla
        //request.setPassword(passwordEncoder.encode(request.getPassword()));

        return EmployeeMappers.ToDTO(
                employeeRepository.save(EmployeeMappers.ToEntityCreate(request, role))
        );
    }

    @Override
    public EmployeeResponse getByEmail(String email) {
        return EmployeeMappers.ToDTO(employeeRepository.findByEmail(email).orElseThrow(()->
                new EmployeeNotFoundException("Empleado no encontrado" + email)) );
    }

    @Override
    public EmployeeResponse update(EmployeeUpdateRequest request) {
        if(employeeRepository.findByEmail(request.getEmail()).isEmpty()){
            throw new RuntimeException("Empleado no encontrado");
        }
        Role role = roleService.findRoleEntityByName(request.getRole());
        request.setId(employeeRepository.findByEmail(request.getEmail()).get().getId());

        return EmployeeMappers.ToDTO(employeeRepository.save(EmployeeMappers.ToEntityUpdate(request,role)));
    }

    @Override
    public String delete(String email) {
        if(employeeRepository.findByEmail(email).isEmpty()){
            throw new RuntimeException("Empleado no encontrado");
        }
        employeeRepository.deleteById(employeeRepository.findByEmail(email).get().getId());

        return "Empleado eliminado correctamente";
    }

    @Override
    public List<EmployeeResponse> getAll() {

        return EmployeeMappers.ToDTOList(employeeRepository.findAll());
    }

    @Override
    public Employees findEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(()->
                new EmployeeNotFoundException("Empleado no encontrado con ID: " + id));
    }
}
