package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsCretateRequest;
import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsUpdateRequest;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.models.dto.Response.salesDetails.SalesDetailsResponse;
import org.example.adventureworks.service.SalesDetailsService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales-details")
public class SaleDetailsController {
    @Autowired
    private SalesDetailsService salesDetailsService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/add-productsale")
    public ResponseEntity<GeneralResponse> AddProductToSale(@Valid @RequestBody SalesDetailsCretateRequest saleData) {
        salesDetailsService.addProductToSale(saleData);
        return ResponseBuilderUtil.buildResponse("Producto agregado a la venta correctamente", org.springframework.http.HttpStatus.CREATED, saleData);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<GeneralResponse> FindById(@PathVariable UUID id) {
        var saleinfo = salesDetailsService.findById(id);
        return ResponseBuilderUtil.buildResponse("Detalle de venta encontrado", org.springframework.http.HttpStatus.OK, saleinfo);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/update-product-sale")
    public ResponseEntity<GeneralResponse> UpdateProductToSale(@Valid @RequestBody SalesDetailsUpdateRequest saleData) {
        var saleinfo = salesDetailsService.updateProductToSale(saleData);
        return ResponseBuilderUtil.buildResponse("Detalle de venta actualizado correctamente", org.springframework.http.HttpStatus.OK, saleinfo);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/delete-product-sale/{id}")
    public ResponseEntity<GeneralResponse> DeleteProductToSale(@PathVariable UUID id) {
        String message = salesDetailsService.deleteProductFromSale(id);
        return ResponseBuilderUtil.buildResponse(message, org.springframework.http.HttpStatus.OK, null);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all-sales-details")
    public ResponseEntity<GeneralResponse> GetAllSalesDetails(){
        var sales = salesDetailsService.findAllSalesDetails();
        return ResponseBuilderUtil.buildResponse("Lista de detalles de ventas", org.springframework.http.HttpStatus.OK, sales);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/total-sales-amount/{saleId}")
    public ResponseEntity<GeneralResponse> GetTotalSalesAmount(@PathVariable UUID saleId){
        List<SalesDetailsResponse> salesDetailToSale = salesDetailsService.findAllSalesDetailsBySale(saleId);

        return ResponseBuilderUtil.buildResponse("El detalle de los productos en la factura ", HttpStatus.OK, salesDetailToSale);
    }
}
