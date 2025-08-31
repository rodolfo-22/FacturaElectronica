package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomersRepository extends JpaRepository<Customers, UUID> {

    //va a devolver un objeto Optional que puede contener un objeto Customers o estar vacio
    //si no encuentra ningun cliente con el email proporcionado
    Optional<Customers> findByEmail(String email);
}
