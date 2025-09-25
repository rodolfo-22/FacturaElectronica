package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.models.dto.Request.category.CategoriesCreateRequest;
import org.example.adventureworks.models.dto.Request.category.CategoriesUpdateRequest;
import org.example.adventureworks.models.dto.Response.Category.CategoryResponse;
import org.example.adventureworks.models.entities.Categories;
import org.example.adventureworks.repository.CategoryRepository;
import org.example.adventureworks.service.CategoryService;
import org.example.adventureworks.utils.mappers.CategoryMappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoriesCreateRequest category) {

        return CategoryMappers.ToDTO(categoryRepository.save(CategoryMappers.ToEntityCreate(category)));
    }

    @Override
    public Categories findByName(String name) {

        return categoryRepository.findByCategoryName(name).orElse(null);
    }

    @Override
    public Categories findById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryResponse updateCategory(CategoriesUpdateRequest category) {
        return null;
    }

    @Override
    public List<CategoryResponse> findAll() {
        return List.of();
    }

    @Override
    public String deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
        return "Exito al eliminar la categoria";
    }

}
