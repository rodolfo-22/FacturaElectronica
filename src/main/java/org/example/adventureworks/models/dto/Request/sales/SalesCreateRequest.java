package org.example.adventureworks.models.dto.Request.sales;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
public class SalesCreateRequest {
    @NotNull(message = "El campo no puede ser nulo")
    private double totalPrice;
    @NotBlank(message = "El campo no puede estar vacío")
    private String saleDate;//fecha de la emicion de la factura
    @NotBlank(message = "El campo no puede estar vacío")
    private String account_tags;//tipo de empresa, "Empresa Nacional"
    @NotBlank(message = "El campo no puede estar vacío")
    private String operation_condition;// credito o debito
    @NotBlank(message = "El campo no puede estar vacío")
    private String types_of_payment; // tipo de pago, transferencia bancaria o cash
    @NotBlank(message = "El campo no puede estar vacío")
    private String pament_installments; // numero de cuotas
    private Date treasury_date; // fecha de pago
    private Date payment_due_date; // fecha de vencimiento
    @NotBlank(message = "El campo no puede estar vacío")
    private String comercial_name; // nombre comercial-persona que atendio la venta
    private String sales_team; // equipo de ventas
    private String journal_entry; // asiento contable-Nacionales o Internacionales o cuentas por cobrar
    private String Proyect; // Proyecto asociado a la venta, equipo de oficina, o construccion,etc
    private String Description; // descripcion de la venta
}
