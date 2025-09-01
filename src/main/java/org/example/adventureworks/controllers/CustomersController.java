package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.CustomerUpdateResquest;
import org.example.adventureworks.models.dto.Request.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.CustomerResponse;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.models.entities.Customers;
import org.example.adventureworks.service.CustomerService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    //@Valid se usa para validar el objeto que se recibe en el cuerpo de la solicitud
    @PostMapping("/new-customer")
    public ResponseEntity<GeneralResponse> NewCustomer(@Valid @RequestBody CustomersCreateRequest customer) {
        CustomerResponse customerCreated = customerService.save(customer);
        //En la clase ResponseBuilderUtil en el metodo buildResponse en caso fue creado mandamos el mensaje "Usuario creado correctamente"
        // con el codigo de estado HttpStatus.CREATED (201) y el objeto customerCreated
        // que contiene los detalles del cliente creado -> customerService.save(customer); -> crea customer y mostramos los detalles
        return ResponseBuilderUtil.buildResponse("Usuario creado correctamente", HttpStatus.CREATED, customerCreated);
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<GeneralResponse> getCustomerByEmail(@PathVariable String email) {
        CustomerResponse customer = customerService.FindbyEmail(email);
        return ResponseBuilderUtil.buildResponse("Usuario encontrado", HttpStatus.OK, customer);
    }

    @GetMapping("/all-customers")
    public ResponseEntity<java.util.List<Customers>> getAllCustomers() {
        List<Customers> customers = customerService.GetAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/update")
    public ResponseEntity<GeneralResponse> updateCustomer(@Valid @RequestBody CustomerUpdateResquest customer) {
        CustomerResponse updatedCustomer = customerService.Update(customer);
        return ResponseBuilderUtil.buildResponse("Usuario actualizado correctamente", HttpStatus.OK, updatedCustomer);
    }

}
