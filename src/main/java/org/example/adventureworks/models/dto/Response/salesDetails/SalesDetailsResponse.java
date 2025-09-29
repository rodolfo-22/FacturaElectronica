package org.example.adventureworks.models.dto.Response.salesDetails;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SalesDetailsResponse {
    private UUID id;
    private int quantity; // Cantidad de productos
    private UUID salesid;
    private UUID productId;
}
