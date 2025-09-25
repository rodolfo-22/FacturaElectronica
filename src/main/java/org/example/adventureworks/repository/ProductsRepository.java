package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
    Optional<Products> findById(UUID uuid);
    Optional<Products> findByProductName(String productName);
}
