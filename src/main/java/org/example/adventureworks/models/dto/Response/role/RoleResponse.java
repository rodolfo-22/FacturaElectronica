package org.example.adventureworks.models.dto.Response.role;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RoleResponse {
    private UUID id;
    private String name;
    private String description;
}
