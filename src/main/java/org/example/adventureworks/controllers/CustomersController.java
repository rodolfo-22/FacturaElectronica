package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.customer.CustomerUpdateResquest;
import org.example.adventureworks.models.dto.Request.customer.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.customer.CustomerResponse;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.service.CustomerService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    //@Valid se usa para validar el objeto que se recibe en el cuerpo de la solicitud
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/new-customer")
    public ResponseEntity<GeneralResponse> NewCustomer(@Valid @RequestBody CustomersCreateRequest customer) {
        CustomerResponse customerCreated = customerService.save(customer);
        //En la clase ResponseBuilderUtil en el metodo buildResponse en caso fue creado mandamos el mensaje "Usuario creado correctamente"
        // con el codigo de estado HttpStatus.CREATED (201) y el objeto customerCreated
        // que contiene los detalles del cliente creado -> customerService.save(customer); -> crea customer y mostramos los detalles
        return ResponseBuilderUtil.buildResponse("Usuario creado correctamente", HttpStatus.CREATED, customerCreated);
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/by-email/{email}")
    public ResponseEntity<GeneralResponse> getCustomerByEmail(@PathVariable String email) {
        CustomerResponse customer = customerService.findbyEmail(email);
        return ResponseBuilderUtil.buildResponse("Usuario encontrado", HttpStatus.OK, customer);
    }
    //@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all-customers")
    public ResponseEntity<GeneralResponse> getAllCustomers() {
        List<CustomerResponse> customers = customerService.GetAllCustomers();
        return ResponseBuilderUtil.buildResponse("Lista de usuarios", HttpStatus.OK, customers);
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<GeneralResponse> updateCustomer(@Valid @RequestBody CustomerUpdateResquest customer) {
        CustomerResponse updatedCustomer = customerService.update(customer);
        return ResponseBuilderUtil.buildResponse("Usuario actualizado correctamente", HttpStatus.OK, updatedCustomer);
    }

    //
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<GeneralResponse> deleteCustomer(@PathVariable String email) {
        String message = customerService.delete(email);
        return ResponseBuilderUtil.buildResponse(message, HttpStatus.OK, null);
    }

}
