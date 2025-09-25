package org.example.adventureworks.models.dto.Response.Category;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CategoryResponse {
    private UUID id;
    private String categoryName;
    private String description;
}
