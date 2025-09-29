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

// El GlobalExceptionHandler maneja las excepciones de toda la aplicación
// y devuelve respuestas HTTP adecuadas con mensajes de error.
// La anotación @RestControllerAdvice indica que esta clase maneja excepciones
// para todos los controladores REST en la aplicación.
// En resumen son errores personalizados para manejar excepciones(errores) comunes
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

    // Cuando un rol no existe
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRoleNotFound(RoleNotFoundException e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }


    // Cuando falla una búsqueda general de cualquier entidad
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    // Cuando falla validación de DTOs con @NotBlank, @NotNull, etc, de cualquier entidad
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException e) {
        List<String> errors = e.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.BAD_REQUEST, errors);
    }

    // Manejo genérico de cualquier otro error de cualquier entidad
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    //Cuando un empleado no existe
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    //Cuando no se encuentra una venta
    @ExceptionHandler(SalesNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSalesNotFound(SalesNotFoundException e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    //Cuando no se encuentra un detalle de venta
    @ExceptionHandler(SalesDetailsNotFoundExeception.class)
    public ResponseEntity<ErrorResponse> handleSalesDetailsNotFound(SalesDetailsNotFoundExeception e) {
        return ResponseBuilderUtil.buildErrorResponse(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

}
