package com.creditovehicular.creditovehicularapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "vehicle_loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLoan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name="currency", nullable = false)
    private Currency currency;

    @Column(name= "started_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startedDate;

    @Column(name="vehicle_price", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double vehiclePrice;

    @Enumerated(EnumType.STRING)
    @Column(name="rate_type", nullable = false)
    private RateType rateType;

    @Column(name="rate_amount", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double rateAmount;

    @Column(name="desgravamen_rate", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double desgravamenRate;

    @Column(name="vehicle_insurance", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double vehicleInsurance;

    @Column(name="physical_shipment", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double physicalShipment;

    @Column(name="payment_period", nullable = false)
    private Integer paymentPeriod;

    @Enumerated(EnumType.STRING)
    @Column(name="grace_type", nullable = false)
    private GraceType graceType;

    @Column(name="grace_period", nullable = false)
    private Integer gracePeriod;

    @Enumerated(EnumType.STRING)
    @Column(name="last_quota", nullable = false)
    private LastQuota lastQuota;
}
