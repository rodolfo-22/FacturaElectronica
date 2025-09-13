package org.example.adventureworks.models.dto.Request.sales;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class SalesUpdateRequest {
    private UUID id;
    private double totalPrice;
    private String saleDate;//fecha de la emicion de la factura
    private String account_tags;//tipo de empresa, "Empresa Nacional"
    private String operation_condition;// credito o debito
    private String types_of_payment; // tipo de pago, transferencia bancaria o cash
    private String pament_installments; // numero de cuotas
    private Date treasury_date; // fecha de pago
    private Date payment_due_date; // fecha de vencimiento
    private String comercial_name; // nombre comercial-persona que atendio la venta
    private String sales_team; // equipo de ventas
    private String journal_entry; // asiento contable-Nacionales o Internacionales o cuentas por cobrar
    private String Proyect; // Proyecto asociado a la venta, equipo de oficina, o construccion,etc
    private String Description; // descripcion de la venta
}
