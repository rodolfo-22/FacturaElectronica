package org.example.adventureworks.models.dto.Request.qrcode;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class QrCodeCreateRequest {
    @NotBlank(message = "El código no puede estar vacío")
    private Date time;
    @NotBlank
    private boolean active;
    @NotBlank(message = "El código no puede estar vacío")
    private String code;
}
