package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.category.CategoriesCreateRequest;
import org.example.adventureworks.models.dto.Response.Category.CategoryResponse;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.models.entities.Categories;
import org.example.adventureworks.service.CategoryService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/new-category")
    public ResponseEntity<GeneralResponse> createNewCategory(@Valid @RequestBody CategoriesCreateRequest category) {

        CategoryResponse categoryResponse = categoryService.createCategory(category);

        return ResponseBuilderUtil.buildResponse("Categoria creada", HttpStatus.CREATED,categoryResponse);
    }
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findByName/{name}")
    public ResponseEntity<GeneralResponse> getCategoryByName(@PathVariable String name) {
        Categories categoryInfo = categoryService.findByName(name);
        return ResponseBuilderUtil.buildResponse("Categoria encontrada", HttpStatus.OK, categoryInfo);
    }
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete-cactegory/{id}")
    public ResponseEntity<GeneralResponse> deleteCategory(@PathVariable UUID id) {
        String deleteCategoryStatus = categoryService.deleteCategory(id);
        return ResponseBuilderUtil.buildResponse("Categoria eliminada", HttpStatus.OK, deleteCategoryStatus);
    }

}
