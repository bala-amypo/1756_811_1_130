package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "warranty_claims")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;
    private String customerName;

    @OneToMany(
        mappedBy = "claim",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<FraudAlertRecord> fraudAlerts;

    // ---------- getters & setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<FraudAlertRecord> getFraudAlerts() {
        return fraudAlerts;
    }

    public void setFraudAlerts(List<FraudAlertRecord> fraudAlerts) {
        this.fraudAlerts = fraudAlerts;
    }
}
