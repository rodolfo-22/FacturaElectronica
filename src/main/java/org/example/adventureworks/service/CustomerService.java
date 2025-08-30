package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.NewCustomerDTO;
import org.example.adventureworks.models.entities.Customers;

import java.util.List;

public interface CustomerService {
    String NewCustomer(NewCustomerDTO newCustomer);
    Customers FindbyEmail(String email);
    List<Customers> GetAllCustomers();
}
