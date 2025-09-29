package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SalesDetailsRepository extends JpaRepository<SalesDetails, UUID> {
    Optional<SalesDetails> findById(UUID uuid);

    //Encontrar todos los detalles de una venta por su ID de venta
    //Es decir, devolver una lista de detalles de venta que pertenezcan a una venta específica
    List<SalesDetails> findAllBySalesId(UUID salesId);
}
