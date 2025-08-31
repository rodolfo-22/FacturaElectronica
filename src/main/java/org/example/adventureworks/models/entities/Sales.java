package org.example.adventureworks.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    // 🔹 Muchas ventas pueden pertenecer a un empleado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id") // FK en la tabla sales,nombre de la columna en la tabla sales
    private Employees employees; //Tipo de dato Employees pero no es el nombre del campo

    // 🔹 Muchas ventas pueden pertenecer a un cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id") // FK en la tabla sales
    private Customers customers;

    //Creando relacion 1:1 con QrCode
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qr_code_id", referencedColumnName = "id")
    private QrCode qr_code;



    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SalesDetails> salesDetails;

}
