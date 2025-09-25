package org.example.adventureworks.models.dto.Request.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriesCreateRequest {
    @NotBlank(message = "El nombre de la categoria no puede ser vasio")
    private String categoryName;
    private String description;
}
