package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SalesDetailsRepository extends JpaRepository<SalesDetails, UUID> {
    Optional<SalesDetails> findById(UUID uuid);
}
