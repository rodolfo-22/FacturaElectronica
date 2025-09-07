package org.example.adventureworks.models.dto.Request.employee;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmployeeCreateRequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @NotBlank(message = "El apellido no puede estar vacío")
    private String surname;
    @NotBlank(message = "El email no puede estar vacío")
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;
    @NotBlank(message = "El rol no puede estar vacío")
    private String role;
    private String address;
    private String phone;
}
