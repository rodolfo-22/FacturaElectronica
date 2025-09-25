package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Categories, UUID> {

    Optional<Categories> findById(UUID id);

    Optional<Categories> findByCategoryName(String name);

}
