package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.products.ProductsCreateResquest;
import org.example.adventureworks.models.dto.Request.products.ProductsUpdateRequest;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.service.ProductsServices;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductoController {
    @Autowired
    private ProductsServices productService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/new-product")
    public ResponseEntity<GeneralResponse> NewProduct(@Valid @RequestBody ProductsCreateResquest productInfo){
        productService.newProduct(productInfo);
        return ResponseBuilderUtil.buildResponse("Producto creada correctamente", HttpStatus.OK, productInfo);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<GeneralResponse> findById(@PathVariable UUID id){
        return ResponseBuilderUtil.buildResponse("Producto encontrado", HttpStatus.OK, productService.findByid(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update-product")
    public ResponseEntity<GeneralResponse> updateProduct(@Valid @RequestBody ProductsUpdateRequest productInfo){
        return ResponseBuilderUtil.buildResponse("Producto actualizado correctamente", HttpStatus.OK, productService.updateProduct(productInfo));
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<GeneralResponse> deleteProduct(@PathVariable UUID id){
        String message = productService.deleteProduct(id);
        return ResponseBuilderUtil.buildResponse(message, HttpStatus.OK, null);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<GeneralResponse> findByName(@PathVariable String name){
        return ResponseBuilderUtil.buildResponse("Producto encontrado", HttpStatus.OK, productService.getProductByName(name));
    }

}
