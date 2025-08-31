package org.example.adventureworks.models.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

//Error Response estandar para manejar errores en la API asi como validaciones
//El formato es similar al de Spring Boot para facilitar la comprension
//y manejo de errores en el cliente
@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private LocalDate time;
    private int status;
    private Object message; //El tipo Object permite mayor flexibilidad asi como listas de errores
    private String path;
}
