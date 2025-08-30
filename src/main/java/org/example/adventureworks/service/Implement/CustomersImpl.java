package org.example.adventureworks.service.Implement;

import org.example.adventureworks.exceptions.CustomerNotFoundException;
import org.example.adventureworks.models.dto.NewCustomerDTO;
import org.example.adventureworks.models.entities.Customers;
import org.example.adventureworks.repository.CustomersRepository;
import org.example.adventureworks.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomersImpl implements CustomerService {

    @Autowired
    private CustomersRepository customersRepository;


    @Override
    public String NewCustomer(NewCustomerDTO newCustomerDTO) {
        Customers customer = new Customers();
        customer.setName(newCustomerDTO.getName());
        customer.setSurname(newCustomerDTO.getSurname());
        customer.setEmail(newCustomerDTO.getEmail());
        customer.setAddress(newCustomerDTO.getAddress());
        customer.setPhone(newCustomerDTO.getPhone());

        customersRepository.save(customer);
        return "Cliente creado exitosamente";
    }

    @Override
    public Customers FindbyEmail(String email) {
        return customersRepository.findByEmail(email).orElseThrow(() -> new CustomerNotFoundException("Cliente con email " + email + " no encontrado"));
    }

    @Override
    public List<Customers> GetAllCustomers() {
        return null;
    }

}
