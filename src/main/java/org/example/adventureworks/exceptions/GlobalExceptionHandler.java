package org.example.adventureworks.exceptions;

import org.example.adventureworks.models.dto.Response.ErrorResponse;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Cuando un cliente no existe
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFound(CustomerNotFoundException e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    // Cuando un producto no existe
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    // Cuando falla una búsqueda general
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    // Cuando falla validación de DTOs con @NotBlank, @NotNull, etc.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException e) {
        List<String> errors = e.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.BAD_REQUEST, errors);
    }

    // Manejo genérico de cualquier otro error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
