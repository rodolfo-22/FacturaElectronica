package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.sales.SalesCreateRequest;
import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsCretateRequest;
import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsUpdateRequest;
import org.example.adventureworks.models.dto.Response.salesDetails.SalesDetailsResponse;
import org.example.adventureworks.models.entities.Products;
import org.example.adventureworks.models.entities.Sales;
import org.example.adventureworks.models.entities.SalesDetails;

import java.util.List;

public class SalesDetailsMappers {

    public static SalesDetails ToEntityCreate(SalesDetailsCretateRequest salesCreateRequest, Products produts, Sales sales, Double totalPrice) {
        return SalesDetails.builder()
                .quantity(salesCreateRequest.getQuantity())
                .totalPrice(totalPrice)
                .products(produts)
                .sales(sales)
                .build();
    }

    public static SalesDetailsResponse ToDTO(SalesDetails salesDetails){
        return SalesDetailsResponse.builder()
                .id(salesDetails.getId())
                .quantity(salesDetails.getQuantity())
                .productId(salesDetails.getProducts().getId())
                .salesid(salesDetails.getSales().getId())
                .build();
    }

    public static SalesDetails ToEntityUpdate(SalesDetailsUpdateRequest salesDetails, Products products, Sales sales, Double totalPrice) {
        return SalesDetails.builder()
                .id(salesDetails.getId())
                .quantity(salesDetails.getQuantity())
                .totalPrice(totalPrice)
                .products(products)
                .sales(sales)
                .build();
    }

    public static List<SalesDetailsResponse> ToDTOList(List<SalesDetails> salesDetails){
        return salesDetails.stream().map(SalesDetailsMappers::ToDTO).toList();
    }
}
