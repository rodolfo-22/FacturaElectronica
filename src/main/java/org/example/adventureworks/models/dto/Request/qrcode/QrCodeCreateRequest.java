package org.example.adventureworks.models.dto.Request.qrcode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class QrCodeCreateRequest {

    @NotNull(message = "La fecha no puede ser nula")
    private Date time;

    @NotNull(message = "El campo activo no puede ser nulo")
    private Boolean active; // Usa Boolean en lugar de boolean

    @NotBlank(message = "El código no puede estar vacío")
    private String code;
}
