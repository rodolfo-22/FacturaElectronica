package org.example.adventureworks.models.dto.Request.products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductsCreateResquest {
    @NotBlank(message = "El nombre del producto no puede estar vacio")
    private String productName;
    @NotBlank(message = "El numero del producto no puede estar vacio")
    private String productNumber;
    @NotBlank(message = "El color del producto no puede estar vacio")
    private String color;
    @NotNull(message = "El precio del producto no puede estar vacio")
    private double price;
    @NotNull(message = "El stock del producto no puede estar vacio")
    private int stock;
    @NotNull(message = "El tamaño del producto no puede estar vacio")
    private String size;
    private String weight;
    @NotBlank(message = "La categoria del producto no puede estar vacia")
    private String model;
    private String description;
    private String imageUrl;
    private UUID categoryId;
}
