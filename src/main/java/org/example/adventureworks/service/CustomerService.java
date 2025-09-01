package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.customer.CustomerUpdateResquest;
import org.example.adventureworks.models.dto.Request.customer.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.customer.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse save(CustomersCreateRequest newCustomer);
    CustomerResponse FindbyEmail(String email);
    CustomerResponse Update(CustomerUpdateResquest updatedCustomer);
    String delete(String email);
    List<CustomerResponse> GetAllCustomers();

}
