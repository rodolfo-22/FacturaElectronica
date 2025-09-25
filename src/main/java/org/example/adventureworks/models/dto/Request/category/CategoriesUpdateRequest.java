package org.example.adventureworks.models.dto.Request.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriesUpdateRequest {
    @NotBlank(message = "El nombre de la categoia no puede ser vacio")
    private String categoryName;
    private String description;
}
