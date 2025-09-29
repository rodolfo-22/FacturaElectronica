package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.sales.SalesCreateRequest;
import org.example.adventureworks.models.dto.Request.sales.SalesUpdateRequest;
import org.example.adventureworks.models.dto.Response.sales.SalesResponse;
import org.example.adventureworks.models.entities.Sales;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface SalesService {
    //Operaciones basicas de CRUD
    SalesResponse newSale(SalesCreateRequest saleInfo);
    SalesResponse findBySaleId(UUID id);
    SalesResponse updateSale(SalesUpdateRequest saleInfo);
    String deleteSale(UUID id);
    List<SalesResponse> findAll();

    //Operaciones adicionales
    List<SalesResponse> findAllBycomercialname(Long customerId); //ventas por empleado
    List<SalesResponse> findbyTime(Date date); //ventas fecha
    List<SalesResponse> findbydates(Date datebegin, Date dateEnd); //ventas entre fechas
    List<SalesResponse> findbyCustumer(String emailCustomer); //ventas por cliente
    Sales findByIdEntity(UUID id); //retorna la entidad
}
