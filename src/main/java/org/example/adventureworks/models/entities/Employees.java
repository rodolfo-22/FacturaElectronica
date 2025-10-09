package org.example.adventureworks.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String address;
    private String phone;

    // 🔹 Un empleado puede tener muchas ventas
    @OneToMany(mappedBy = "employees", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Sales> sales;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roles_id")
    private Role roles;

}

