package org.example.adventureworks.repository;

import org.example.adventureworks.models.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<Employees, UUID> {

    Optional<Employees> findByEmail(String email);
}
