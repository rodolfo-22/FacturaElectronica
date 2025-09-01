package org.example.adventureworks.models.dto.Request.customer;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CustomerUpdateResquest {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
}
