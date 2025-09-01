package org.example.adventureworks.models.dto.Request.role;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RoleCreateRequest {
    @NotBlank
    private String name;
    private String description;
}
