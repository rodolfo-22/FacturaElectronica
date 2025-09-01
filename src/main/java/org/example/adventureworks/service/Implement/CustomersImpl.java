package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.exceptions.CustomerNotFoundException;
import org.example.adventureworks.models.dto.Request.CustomerUpdateResquest;
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
        //como estamos retornando un CustomerResponse, usamos el mapeador ToDTO que convierte de Customers a CustomerResponse
        //el metodo findByEmail retorna un Optional<Customers>, por lo que usamos orElseThrow para lanzar una excepcion si no se encuentra el cliente
        return CustomerMappers.ToDTO(customersRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Cliente no encontrado")));
    }

    @Override
    public CustomerResponse Update(CustomerUpdateResquest updatedCustomer) {
        if(customersRepository.findByEmail(updatedCustomer.getEmail()).isEmpty())
            throw new CustomerNotFoundException("Cliente no encontrado con el correo: " + updatedCustomer.getEmail());
        
        //Asignamos el id del cliente encontrado al cliente que vamos a actualizar
        updatedCustomer.setId(customersRepository.findByEmail(updatedCustomer.getEmail()).get().getId());

        return CustomerMappers.ToDTO(customersRepository.save(CustomerMappers.ToEntityUpdate(updatedCustomer)));
    }

    @Override
    public List<Customers> GetAllCustomers() {
        return customersRepository.findAll();
    }

}
