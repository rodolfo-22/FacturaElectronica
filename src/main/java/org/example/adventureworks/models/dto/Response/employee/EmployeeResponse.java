package org.example.adventureworks.models.dto.Response.employee;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmployeeResponse {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
}
