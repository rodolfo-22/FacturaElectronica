package org.example.adventureworks.models.dto.Response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

// Esta clase se utiliza para respuestas generales de la API, asi como para respuestas exitosas
// que no requieren un formato especifico.
@Data
@Builder
public class GeneralResponse {
    private String uri;
    private String message;
    private int status;
    private LocalDate time;
    private Object data;
}
