package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.sales.SalesCreateRequest;
import org.example.adventureworks.models.dto.Request.sales.SalesUpdateRequest;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.models.dto.Response.sales.SalesResponse;

import org.example.adventureworks.service.SalesService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/new-sale")
    public ResponseEntity<GeneralResponse>NewSale(@Valid @RequestBody SalesCreateRequest saleInfo){
        salesService.newSale(saleInfo);
        return ResponseBuilderUtil.buildResponse("Venta creada correctamente", HttpStatus.CREATED, saleInfo);
    }
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<GeneralResponse> FindById(@PathVariable UUID id){
        SalesResponse saleinfo = salesService.findBySaleId(id);
        return ResponseBuilderUtil.buildResponse("Venta encontrada", HttpStatus.OK, saleinfo);
    }
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/update-sale")
    public ResponseEntity<GeneralResponse> UpdateSale(@Valid @RequestBody SalesUpdateRequest saleInfo){
        SalesResponse saleinfo = salesService.updateSale(saleInfo);
        return ResponseBuilderUtil.buildResponse("Venta actualizada correctamente", HttpStatus.OK, saleinfo);
    }
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/delete-sale/{id}")
    public ResponseEntity<GeneralResponse> DeleteSale(@PathVariable UUID id){
        String message = salesService.deleteSale(id);
        return ResponseBuilderUtil.buildResponse(message, HttpStatus.OK, null);
    }
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all-sales")
    public ResponseEntity<GeneralResponse> GetAllSales(){
        List<SalesResponse> sales = salesService.findAll();
        return ResponseBuilderUtil.buildResponse("Lista de ventas", HttpStatus.OK, sales);
    }

}
