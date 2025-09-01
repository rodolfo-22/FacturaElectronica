package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.CustomerUpdateResquest;
import org.example.adventureworks.models.dto.Request.CustomersCreateRequest;
import org.example.adventureworks.models.dto.Response.CustomerResponse;
import org.example.adventureworks.models.entities.Customers;

//La clase Mapper se utiliza para convertir entre diferentes tipos de objetos, como DTOs y entidades.
//En este caso, se puede utilizar para convertir entre Customers y customerResponse DTOs a Customers entidades.

public class CustomerMappers {

    //Convertir CustomersCreateRequest a Customers
    public static Customers ToEntityCreate(CustomersCreateRequest customerRequest){
        return Customers.builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .phone(customerRequest.getPhone())
                .build();
    }

    //Convertir Customers a CustomerResponse
    public static CustomerResponse ToDTO(Customers customer){
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .build();
    }

    //Para modificar un cliente
    public static Customers ToEntityUpdate(CustomerUpdateResquest updatedCustomer){
        return Customers.builder()
                .id(updatedCustomer.getId())
                .name(updatedCustomer.getName())
                .surname(updatedCustomer.getSurname())
                .email(updatedCustomer.getEmail())
                .address(updatedCustomer.getAddress())
                .phone(updatedCustomer.getPhone())
                .build();
    }

}
