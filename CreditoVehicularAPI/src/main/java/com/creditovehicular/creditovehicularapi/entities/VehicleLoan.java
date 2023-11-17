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

    @Column(name="code", nullable = false)
    private String code;

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

    @Column(name="loan_percentage", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double loanPercentage;

    @Enumerated(EnumType.STRING)
    @Column(name="rate_type", nullable = false)
    private RateType rateType;

    @Column(name="rate_amount", nullable = false, columnDefinition = "DECIMAL(10,8)")
    private Double rateAmount;

    @Column(name="rate_capitalization", nullable = false)
    private String rateCapitalization;

    @Column(name="desgravamen_rate", nullable = false, columnDefinition = "DECIMAL(10,8)")
    private Double desgravamenRate;

    @Column(name="vehicle_insurance", nullable = false, columnDefinition = "DECIMAL(10,8)")
    private Double vehicleInsurance;

    @Column(name="annual_cok", nullable = false, columnDefinition = "DECIMAL(10,8)")
    private Double annualCok;

    @Column(name="physical_shipment", nullable = false, columnDefinition = "DECIMAL(10,4)")
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

    @Column(name="notary_costs", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private Double notaryCosts;

    @Column(name="registration_costs", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private Double registrationCosts;

    @Column(name="appraisal", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private Double appraisal;

    @Column(name="administration_costs", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private Double administrationCosts;

}
