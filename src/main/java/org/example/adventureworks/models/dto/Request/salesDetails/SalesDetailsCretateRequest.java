package org.example.adventureworks.models.dto.Request.salesDetails;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SalesDetailsCretateRequest {

    @NotNull(message = "La cantidad no puede ser nula")
    private int quantity; // Cantidad de productos
    @NotNull(message = "La venta no puede ser nula")
    private UUID salesid;
    @NotNull(message = "El producto no puede ser nulo")
    private UUID productId;

}
