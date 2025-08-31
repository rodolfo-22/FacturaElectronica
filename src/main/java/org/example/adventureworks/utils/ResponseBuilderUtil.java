package org.example.adventureworks.utils;

import org.example.adventureworks.models.dto.Response.ErrorResponse;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

// Clase utilitaria para construir respuestas de error estandarizadas
// que pueden ser reutilizadas en diferentes controladores o manejadores de excepciones
// para mantener la consistencia en las respuestas de error de la API.
public class ResponseBuilderUtil {
    // Metodo para construir una respuesta de error
    public static ResponseEntity<ErrorResponse> buildErrorResponse(Exception e, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity.status(status).body(ErrorResponse.builder()
                .message(data) //campo message de ErrorResponse
                .status(status.value())//codigo de estado HTTP, ejemplo 404, 500, etc.,campo status de ErrorResponse
                .time(LocalDate.now())//fecha del error, campo time de ErrorResponse
                .path(uri)//ruta del endpoint que genero el error, campo path de ErrorResponse
                .build());//Construccion del objeto ErrorResponse usando el patron builder
    }

    // Metodo para construir una respuesta general de éxito
    public static ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity.status(status).body(GeneralResponse.builder()
                .message(message)
                .status(status.value())
                .data(data)
                .uri(uri)
                .time(LocalDate.now())
                .build());
    }
}
