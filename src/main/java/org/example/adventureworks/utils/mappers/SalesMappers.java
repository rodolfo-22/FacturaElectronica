package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.sales.SalesCreateRequest;
import org.example.adventureworks.models.dto.Request.sales.SalesUpdateRequest;
import org.example.adventureworks.models.dto.Response.sales.SalesResponse;
import org.example.adventureworks.models.entities.Sales;

import java.util.List;

public class SalesMappers {

    public static Sales  ToEntityCreate(SalesCreateRequest salesCreateRequest) {
        return Sales.builder()
                .totalPrice(salesCreateRequest.getTotalPrice())
                .account_tags(salesCreateRequest.getAccount_tags())
                .operation_condition(salesCreateRequest.getOperation_condition())
                .types_of_payment(salesCreateRequest.getTypes_of_payment())
                .pament_installments(salesCreateRequest.getPament_installments())
                .treasury_date(salesCreateRequest.getTreasury_date())
                .payment_due_date(salesCreateRequest.getPayment_due_date())
                .comercial_name(salesCreateRequest.getComercial_name())
                .sales_team(salesCreateRequest.getSales_team())
                .journal_entry(salesCreateRequest.getJournal_entry())
                .Proyect(salesCreateRequest.getProyect())
                .Description(salesCreateRequest.getDescription())
                .build();
    }
    public static SalesResponse ToDTO(Sales sales){
        return SalesResponse.builder()
                .id(sales.getId())
                .totalPrice(sales.getTotalPrice())
                .saleDate(sales.getSaleDate())
                .account_tags(sales.getAccount_tags())
                .operation_condition(sales.getOperation_condition())
                .types_of_payment(sales.getTypes_of_payment())
                .pament_installments(sales.getPament_installments())
                .treasury_date(sales.getTreasury_date())
                .payment_due_date(sales.getPayment_due_date())
                .comercial_name(sales.getComercial_name())
                .sales_team(sales.getSales_team())
                .journal_entry(sales.getJournal_entry())
                .Proyect(sales.getProyect())
                .Description(sales.getDescription())
                .build();
    }
    public static Sales ToEntityUpdate(SalesUpdateRequest updateSales){
        return Sales.builder()
                .id(updateSales.getId())
                .totalPrice(updateSales.getTotalPrice())
                .account_tags(updateSales.getAccount_tags())
                .operation_condition(updateSales.getOperation_condition())
                .types_of_payment(updateSales.getTypes_of_payment())
                .pament_installments(updateSales.getPament_installments())
                .treasury_date(updateSales.getTreasury_date())
                .payment_due_date(updateSales.getPayment_due_date())
                .comercial_name(updateSales.getComercial_name())
                .sales_team(updateSales.getSales_team())
                .journal_entry(updateSales.getJournal_entry())
                .Proyect(updateSales.getProyect())
                .Description(updateSales.getDescription())
                .build();
    }

    public static List<SalesResponse> ToDTOList(List<Sales> sales){
        return sales.stream().map(SalesMappers::ToDTO).toList();
    }
}
