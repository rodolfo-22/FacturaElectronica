package org.example.adventureworks.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "qrcodes")
public class QrCode {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    private Date time;
    private boolean active;
    private String code;

    //Relacion 1:1 con sales
    @OneToOne(mappedBy = "qr_code")
    private Sales sales;

}
