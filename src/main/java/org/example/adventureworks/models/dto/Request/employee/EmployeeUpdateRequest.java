package org.example.adventureworks.models.dto.Request.employee;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.example.adventureworks.models.entities.Role;

import java.util.UUID;

@Data
@Builder
public class EmployeeUpdateRequest {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String email;
    private String role;
    @NotBlank
    private String password;
    private String address;
    private String phone;
}
