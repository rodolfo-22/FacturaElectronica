package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.category.CategoriesUpdateRequest;
import org.example.adventureworks.models.dto.Response.Category.CategoryResponse;
import org.example.adventureworks.models.dto.Request.category.CategoriesCreateRequest;
import org.example.adventureworks.models.entities.Categories;

import java.util.List;
import java.util.UUID;


public interface CategoryService {
    CategoryResponse createCategory(CategoriesCreateRequest category);
    Categories findByName(String name);
    Categories findById(UUID id);
    CategoryResponse updateCategory(CategoriesUpdateRequest category);
    List<CategoryResponse> findAll();
    String deleteCategory(UUID id);
}
