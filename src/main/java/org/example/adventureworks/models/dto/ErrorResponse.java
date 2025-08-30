package org.example.adventureworks.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private Object message; //El tipo Object permite mayor flexibilidad asi como listas de errores
    private String path;
}
