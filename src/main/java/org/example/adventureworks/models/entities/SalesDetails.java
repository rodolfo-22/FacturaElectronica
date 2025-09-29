package org.example.adventureworks.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SalesDetails")
public class SalesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int quantity; // Cantidad de productos
    private double totalPrice; // Precio total (quantity * unitPrice(que viene de products))

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id") // FK en la tabla SalesDetails
    private Sales sales; //Tipo de dato Sales pero no es el nombre del campo

    // 🔹 Detalle ventas un producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id") // FK en la tabla sales
    private Products products;

}
