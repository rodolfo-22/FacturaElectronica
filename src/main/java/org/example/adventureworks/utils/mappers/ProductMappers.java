package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.products.ProductsCreateResquest;
import org.example.adventureworks.models.dto.Request.products.ProductsUpdateRequest;
import org.example.adventureworks.models.dto.Response.products.ProductsResponse;
import org.example.adventureworks.models.entities.Categories;
import org.example.adventureworks.models.entities.Products;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMappers {

    public static Products ToEntityCreate(ProductsCreateResquest productinfo, Categories category) {
        return Products.builder()
                .productName(productinfo.getProductName())
                .productNumber(productinfo.getProductNumber())
                .color(productinfo.getColor())
                .price(productinfo.getPrice())
                .stock(productinfo.getStock())
                .size(productinfo.getSize())
                .weight(productinfo.getWeight())
                .model(productinfo.getModel())
                .description(productinfo.getDescription())
                .imageUrl(productinfo.getImageUrl())
                .categories(category)
                .build();
    }

    public static ProductsResponse ToDTO(Products product) {
        return ProductsResponse.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .productNumber(product.getProductNumber())
                .color(product.getColor())
                .price(product.getPrice())
                .stock(product.getStock())
                .size(product.getSize())
                .weight(product.getWeight())
                .model(product.getModel())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .build();
    }

    public static Products ToEntityUpdate(ProductsUpdateRequest updatedProduct, Categories category) {
        return Products.builder()
                .id(updatedProduct.getProductId())
                .productName(updatedProduct.getProductName())
                .productNumber(updatedProduct.getProductNumber())
                .color(updatedProduct.getColor())
                .price(updatedProduct.getPrice())
                .stock(updatedProduct.getStock())
                .size(updatedProduct.getSize())
                .weight(updatedProduct.getWeight())
                .model(updatedProduct.getModel())
                .description(updatedProduct.getDescription())
                .imageUrl(updatedProduct.getImageUrl())
                .categories(category)
                .build();
    }

    public static List<ProductsResponse> ToDTOList(List<Products> allProducts) {

        return allProducts.stream().map(ProductMappers::ToDTO).collect(Collectors.toList());
    }
}
