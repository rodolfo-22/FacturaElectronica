package org.example.adventureworks.models.dto.Request.role;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RoleUpdateRequest {
    private UUID id;
    private String name;
    private String description;
}
