package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.CustomerUpdateResquest;
import org.example.adventureworks.models.dto.Request.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.CustomerResponse;
import org.example.adventureworks.models.entities.Customers;

import java.util.List;

public interface CustomerService {
    CustomerResponse save(CustomersCreateRequest newCustomer);
    CustomerResponse FindbyEmail(String email);
    CustomerResponse Update(CustomerUpdateResquest updatedCustomer);
    String delete(String email);
    List<CustomerResponse> GetAllCustomers();

}
