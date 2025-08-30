package org.example.adventureworks.utils;

import org.example.adventureworks.models.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

// Clase utilitaria para construir respuestas de error estandarizadas
// que pueden ser reutilizadas en diferentes controladores o manejadores de excepciones
// para mantener la consistencia en las respuestas de error de la API.
public class ResponseBuilderUtil {

    public static ResponseEntity<ErrorResponse> buildErrorResponse(Exception ex, HttpStatus status, Object message) {
        String path = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest()
                .getRequestURI();

        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                status.value(),
                message,
                path
        );

        return new ResponseEntity<>(errorResponse, status);
    }
}
