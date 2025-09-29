package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsCretateRequest;
import org.example.adventureworks.models.dto.Request.salesDetails.SalesDetailsUpdateRequest;
import org.example.adventureworks.models.dto.Response.salesDetails.SalesDetailsResponse;
import org.example.adventureworks.models.entities.Products;
import org.example.adventureworks.models.entities.Sales;
import org.example.adventureworks.models.entities.SalesDetails;
import org.example.adventureworks.repository.SalesDetailsRepository;
import org.example.adventureworks.service.ProductsServices;
import org.example.adventureworks.service.SalesDetailsService;
import org.example.adventureworks.utils.mappers.SalesDetailsMappers;
import org.example.adventureworks.utils.mappers.SalesMappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SalesDetailsServiceImpl implements SalesDetailsService {

    private final SalesServiceImpl salesService;
    private final ProductsServices productService;
    private final SalesDetailsRepository salesDetailsRepository;

    @Override
    public SalesDetailsResponse addProductToSale(SalesDetailsCretateRequest salesDetailsCretateRequest) {

        Products product = productService.findByIdEntity(salesDetailsCretateRequest.getProductId());

        Sales sale = salesService.findByIdEntity(salesDetailsCretateRequest.getSalesid());

        if (product == null || sale == null)
            return null;

        Double totalPrice = product.getPrice() * salesDetailsCretateRequest.getQuantity();

        return SalesDetailsMappers.ToDTO(salesDetailsRepository.save(SalesDetailsMappers.ToEntityCreate(salesDetailsCretateRequest, product, sale, totalPrice)));
    }

    @Override
    public SalesDetailsResponse findById(UUID id) {
        return SalesDetailsMappers.ToDTO(salesDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado con el id: " + id)));
    }

    @Override
    public SalesDetailsResponse updateProductToSale(SalesDetailsUpdateRequest salesDetailsUpdateRequest) {
        Products product = productService.findByIdEntity(salesDetailsUpdateRequest.getProductId());

        Sales sale = salesService.findByIdEntity(salesDetailsUpdateRequest.getSalesid());

        System.out.println("Actualizando detalle de venta con id: " + salesDetailsUpdateRequest.getId());

        if (product == null || sale == null)
            return null;
        Double totalPrice = product.getPrice() * salesDetailsUpdateRequest.getQuantity();

        if (salesDetailsRepository.findById(salesDetailsUpdateRequest.getId()).isEmpty())
            return null;


        return SalesDetailsMappers.ToDTO(salesDetailsRepository.save(SalesDetailsMappers.ToEntityUpdate(salesDetailsUpdateRequest, product, sale, totalPrice)));
    }

    @Override
    public String deleteProductFromSale(UUID id) {
        if (salesDetailsRepository.findById(id).isEmpty())
            return "Detalle de venta no encontrado con el id: " + id;
        salesDetailsRepository.deleteById(id);
        return "Detalle de venta eliminado con exito " + id;
    }

    @Override
    public List<SalesDetailsResponse> findAllSalesDetails() {
        return SalesDetailsMappers.ToDTOList(salesDetailsRepository.findAll());
    }

    @Override
    public List<SalesDetailsResponse> findAllSalesDetailsBySale(UUID saleId) {
        List<SalesDetails> details = salesDetailsRepository.findAllBySalesId(saleId);

        return SalesDetailsMappers.ToDTOList(details);
    }

}
