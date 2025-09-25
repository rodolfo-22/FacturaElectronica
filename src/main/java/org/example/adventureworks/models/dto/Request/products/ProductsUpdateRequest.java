package org.example.adventureworks.models.dto.Request.products;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductsUpdateRequest {
    private UUID productId;
    private String productName;
    private String productNumber;
    private String color;
    private double price;
    private int stock;
    private String size;
    private String weight;
    private String category;
    private String model;
    private String description;
    private String imageUrl;
    private UUID categoryId;
}
