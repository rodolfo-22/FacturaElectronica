package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsCretateRequest;
import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsUpdateRequest;
import org.example.adventureworks.models.dto.Response.salesDetails.SalesDetailsResponse;

import java.util.List;
import java.util.UUID;

public interface SalesDetailsService {
    SalesDetailsResponse addProductToSale(SalesDetailsCretateRequest salesDetailsCretateRequest);
    SalesDetailsResponse findById(UUID id);
    SalesDetailsResponse updateProductToSale(SalesDetailsUpdateRequest salesDetailsUpdateRequest);
    String deleteProductFromSale(UUID id);
    List<SalesDetailsResponse> findAllSalesDetails();

    // Consultas especiales
    List<SalesDetailsResponse> findAllSalesDetailsBySale(UUID SaleId);

}
