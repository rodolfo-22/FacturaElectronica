package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sales, UUID> {
    Optional<Sales> findById(UUID idOrder);
}
