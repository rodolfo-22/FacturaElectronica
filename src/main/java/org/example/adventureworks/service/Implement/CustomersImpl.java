package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.models.dto.Request.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.CustomerResponse;
import org.example.adventureworks.models.entities.Customers;
import org.example.adventureworks.repository.CustomersRepository;
import org.example.adventureworks.service.CustomerService;
import org.example.adventureworks.utils.mappers.CustomerMappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomersImpl implements CustomerService {
    //Inyeccion de dependencias
    //La propiedad es final para asegurar que no cambie despues de la inyeccion
    //es decir, si alguien intenta reasignar el repositorio, no podra hacerlo
    //por ejemplo customersRepository = null; //Esto causaria un error de compilacion
    private final CustomersRepository customersRepository;


    @Override
    public CustomerResponse save(CustomersCreateRequest newCustomer){

        return CustomerMappers.ToDTO(customersRepository.save(CustomerMappers.ToEntityCreate(newCustomer)));
    }

    @Override
    public CustomerResponse FindbyEmail(String email) {
        return null;
    }

    @Override
    public List<Customers> GetAllCustomers() {
        return customersRepository.findAll();
    }

}
