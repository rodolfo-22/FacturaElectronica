package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.exceptions.ProductNotFoundException;
import org.example.adventureworks.models.dto.Request.products.ProductsCreateResquest;
import org.example.adventureworks.models.dto.Request.products.ProductsUpdateRequest;
import org.example.adventureworks.models.dto.Response.products.ProductsResponse;
import org.example.adventureworks.models.entities.Categories;
import org.example.adventureworks.models.entities.Products;
import org.example.adventureworks.repository.ProductsRepository;
import org.example.adventureworks.service.CategoryService;
import org.example.adventureworks.service.ProductsServices;
import org.example.adventureworks.utils.mappers.ProductMappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsServices {
    private final ProductsRepository productsRepository;
    private final CategoryService categoryService;


    @Override
    public ProductsResponse newProduct(ProductsCreateResquest productsCreateResquest) {

        return ProductMappers.ToDTO(productsRepository.save(ProductMappers.ToEntityCreate(productsCreateResquest,categoryService.findById(productsCreateResquest.getCategoryId()))));
    }

    @Override
    public ProductsResponse findByid(UUID productId) {
        return ProductMappers.ToDTO(productsRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("Product not found with id: " + productId)));
    }

    @Override
    public ProductsResponse updateProduct(ProductsUpdateRequest productsUpdateRequest) {

        if(categoryService.findById(productsUpdateRequest.getCategoryId())==null)
            throw new ProductNotFoundException("Category not found with id: " + productsUpdateRequest.getCategoryId());

        System.out.println("El ID DE ESTE PRODUCTO ES: "+productsUpdateRequest.getProductId());

        if(productsRepository.findById(productsUpdateRequest.getProductId()).isEmpty())
            throw new ProductNotFoundException("Product not found with id: " + productsUpdateRequest.getProductId());

        return ProductMappers.ToDTO(productsRepository.save(ProductMappers.ToEntityUpdate(productsUpdateRequest,categoryService.findById(productsUpdateRequest.getCategoryId()))));
    }

    @Override
    public String deleteProduct(UUID productId) {
        if(productsRepository.findById(productId).isEmpty())
            throw new ProductNotFoundException("Product not found with id: " + productId);

        productsRepository.deleteById(productId);

        return "Product deleted with id: " + productId;
    }

    @Override
    public List<ProductsResponse> getAllProducts() {
        return List.of();
    }

    //Buen ejemplo de como mapper comvierte entity a dto (ProductResponse)
    @Override
    public ProductsResponse getProductByName(String productName) {
        Products product = productsRepository.findByProductName(productName)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con nombre: " + productName));

        return ProductMappers.ToDTO(product);
    }

    @Override
    public Products findByIdEntity(UUID productId) {
        return productsRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException("Product not found with id: " + productId));
    }


}
