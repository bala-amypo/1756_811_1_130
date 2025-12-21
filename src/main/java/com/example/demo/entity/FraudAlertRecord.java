package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long claimId;
    private String serialNumber;
    private String alertType;
    private String severity;
    private String message;

    private Boolean resolved = false;
    private LocalDateTime alertDate;

    @ManyToOne
    @JoinColumn(name = "claim_id_fk")
    private WarrantyClaimRecord claim;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public FraudAlertRecord() {}

    public FraudAlertRecord(Long claimId, String serialNumber, String alertType) {
        this.claimId = claimId;
        this.serialNumber = serialNumber;
        this.alertType = alertType;
    }

    @PrePersist
    public void onCreate() {
        this.alertDate = LocalDateTime.now();
    }

    // ---------- GETTERS & SETTERS (VERY IMPORTANT) ----------

    public Long getId() {
        return id;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
