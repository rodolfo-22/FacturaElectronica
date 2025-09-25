package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.products.ProductsCreateResquest;
import org.example.adventureworks.models.dto.Request.products.ProductsUpdateRequest;
import org.example.adventureworks.models.dto.Response.products.ProductsResponse;

import java.util.List;
import java.util.UUID;

public interface ProductsServices {
    ProductsResponse newProduct(ProductsCreateResquest productsCreateResquest);
    ProductsResponse findByid(UUID productId);
    ProductsResponse updateProduct(ProductsUpdateRequest productsUpdateRequest);
    String deleteProduct(UUID productId);
    List<ProductsResponse> getAllProducts();
    
    //Cosultas especiales
    ProductsResponse getProduct(UUID productId);
    
}
