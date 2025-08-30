package org.example.adventureworks.controllers;

import org.apache.coyote.Response;
import org.example.adventureworks.models.dto.NewCustomerDTO;
import org.example.adventureworks.models.entities.Customers;
import org.example.adventureworks.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/new-customer")
    public ResponseEntity<String> NewCustomer(@RequestBody NewCustomerDTO customer) {
        String response = customerService.NewCustomer(customer);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<Customers> getCustomer(@PathVariable String email) {
        Customers customer = customerService.FindbyEmail(email);
        return ResponseEntity.ok(customer);
    }

}
