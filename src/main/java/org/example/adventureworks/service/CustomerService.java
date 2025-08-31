package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.NewCustomerDTO;
import org.example.adventureworks.models.dto.Request.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.CustomerResponse;
import org.example.adventureworks.models.entities.Customers;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerResponse save(CustomersCreateRequest newCustomer);
    CustomerResponse FindbyEmail(String email);
    List<Customers> GetAllCustomers();
}
