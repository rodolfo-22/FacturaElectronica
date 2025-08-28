package org.example.adventureworks.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Data
@Entity
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "InformationCompany")
public class InformationCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String companyName;
    private String address;
    private String phone;
    private String email;
    private String taxId;
    private String NIT;
}
