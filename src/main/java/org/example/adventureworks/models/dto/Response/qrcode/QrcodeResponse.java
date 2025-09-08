package org.example.adventureworks.models.dto.Response.qrcode;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class QrcodeResponse {
    private UUID id;
    private Date time;
    private boolean active;
    private String code;
}
