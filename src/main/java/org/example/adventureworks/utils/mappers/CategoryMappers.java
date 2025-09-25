package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.category.CategoriesCreateRequest;
import org.example.adventureworks.models.dto.Response.Category.CategoryResponse;
import org.example.adventureworks.models.entities.Categories;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMappers {
    public static Categories ToEntityCreate(CategoriesCreateRequest categoriesCreateRequest) {
        return Categories.builder()
                .categoryName(categoriesCreateRequest.getCategoryName())
                .description(categoriesCreateRequest.getDescription())
                .build();
    }
    public static CategoryResponse ToDTO(Categories categories) {
        return CategoryResponse.builder()
                .id(categories.getId())
                .categoryName(categories.getCategoryName())
                .description(categories.getDescription())
                .build();

    }
    public static List<CategoryResponse> ToDTOList (List<Categories> categoriesList) {
        return categoriesList.stream().map(CategoryMappers::ToDTO).collect(Collectors.toList());
    }
}
