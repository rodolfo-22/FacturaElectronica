package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.customer.CustomerUpdateResquest;
import org.example.adventureworks.models.dto.Request.customer.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.customer.CustomerResponse;
import org.example.adventureworks.models.entities.Customers;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerResponse save(CustomersCreateRequest newCustomer);
    CustomerResponse findbyEmail(String email);
    CustomerResponse update(CustomerUpdateResquest updatedCustomer);
    String delete(String email);
    List<CustomerResponse> GetAllCustomers();
    Customers findById(UUID id);
}
