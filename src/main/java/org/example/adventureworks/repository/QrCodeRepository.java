package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QrCodeRepository extends JpaRepository<QrCode, UUID> {
    Optional<QrCode> findById(UUID id);
    Optional<QrCode> findByCode(String code);
    Optional<QrCode> deleteByCode(String code);
}
