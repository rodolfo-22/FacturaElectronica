package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.exceptions.SalesNotFoundException;
import org.example.adventureworks.models.dto.Request.sales.SalesCreateRequest;
import org.example.adventureworks.models.dto.Request.sales.SalesUpdateRequest;
import org.example.adventureworks.models.dto.Response.sales.SalesResponse;
import org.example.adventureworks.models.entities.Customers;
import org.example.adventureworks.models.entities.Employees;
import org.example.adventureworks.repository.SalesRepository;
import org.example.adventureworks.service.SalesService;
import org.example.adventureworks.utils.mappers.SalesMappers;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;
    private final CustomerServiceImpl customerService;
    private final EmployeeServiceImpl employeeService;

    @Override
    public SalesResponse newSale(SalesCreateRequest saleInfo) {
        Employees employees_info = null;
        Customers customer_info = null;

        if (customerService.findById(saleInfo.getCustomer_id()) != null)
            customer_info = customerService.findById(saleInfo.getCustomer_id());

        if( employeeService.findEmployeeById(saleInfo.getEmployee_id()) != null)
            employees_info = employeeService.findEmployeeById(saleInfo.getEmployee_id());


        return SalesMappers.ToDTO(salesRepository.save(SalesMappers.ToEntityCreate(saleInfo, customer_info, employees_info)));
    }

    @Override
    public SalesResponse findBySaleId(UUID id) {
        return SalesMappers.ToDTO(
                salesRepository.findById(id)
                        .orElseThrow(() -> new SalesNotFoundException("Venta no encontrada con el id: " + id))
        );
    }

    @Override
    public SalesResponse updateSale(SalesUpdateRequest saleInfo) {

        Employees employees = employeeService.findEmployeeById(saleInfo.getEmployee_id());
        Customers  customers = customerService.findById(saleInfo.getCustomer_id());

        if (salesRepository.findById(saleInfo.getId()).isEmpty())
            throw new SalesNotFoundException("Venta no encontrada con el id: " + saleInfo.getId());

        //No hacemos validacion de customer_id y employee_id porque ya se hizo arriba

        return SalesMappers.ToDTO(salesRepository.save(SalesMappers.ToEntityUpdate(saleInfo, customers, employees)));
    }

    @Override
    public String deleteSale(UUID id) {
        if (salesRepository.findById(id).isEmpty())
            throw new SalesNotFoundException("Venta no encontrada con el id: " + id);
        salesRepository.deleteById(id);
        return "Se ha eliminado la venta con el id: " + id;
    }

    @Override
    public List<SalesResponse> findAll() {
        return SalesMappers.ToDTOList(salesRepository.findAll());
    }


    //   ** TODO: Terminar consultas especiales  **

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
