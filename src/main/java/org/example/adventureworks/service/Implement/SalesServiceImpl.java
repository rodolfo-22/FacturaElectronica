package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.models.dto.Request.sales.SalesCreateRequest;
import org.example.adventureworks.models.dto.Request.sales.SalesUpdateRequest;
import org.example.adventureworks.models.dto.Response.sales.SalesResponse;
import org.example.adventureworks.service.SalesService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SalesServiceImpl implements SalesService {
    @Override
    public SalesResponse newSale(SalesCreateRequest saleInfo) {
        return null;
    }

    @Override
    public SalesResponse findById(UUID id) {
        return null;
    }

    @Override
    public SalesResponse updateSale(SalesUpdateRequest saleInfo) {
        return null;
    }

    @Override
    public String deleteSale(UUID id) {
        return "";
    }

    @Override
    public List<SalesResponse> findAll() {
        return List.of();
    }

    @Override
    public List<SalesResponse> findAllBycomercialname(Long customerId) {
        return List.of();
    }

    @Override
    public List<SalesResponse> findbyTime(Date date) {
        return List.of();
    }

    @Override
    public List<SalesResponse> findbydates(Date datebegin, Date dateEnd) {
        return List.of();
    }

    @Override
    public List<SalesResponse> findbyCustumer(String emailCustomer) {
        return List.of();
    }
}
