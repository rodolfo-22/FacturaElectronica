package org.example.adventureworks.models.dto.Request.qrcode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class QrCodeUpdateRequest {
    private UUID id;

    @NotNull(message = "La fecha no puede ser nula")
    private Date time;

    private boolean active;

    @NotBlank(message = "El código no puede estar vacío")
    private String code;

}
