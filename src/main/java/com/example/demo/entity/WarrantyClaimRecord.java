package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // foreign key reference (serial number of device)
    private String serialNumber;

    private String claimantName;
    private String claimantEmail;
    private String claimReason;

    // default value PENDING
    private String status = "PENDING";

    private LocalDateTime submittedAt;
    private LocalDateTime createdAt;

    // MANY CLAIMS → ONE DEVICE
    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    // ONE CLAIM → MANY FRAUD ALERTS
    @OneToMany(mappedBy = "claim")
    private List<FraudAlertRecord> alerts;

    // no-args constructor
    public WarrantyClaimRecord() {}

    // core fields constructor
    public WarrantyClaimRecord(String serialNumber, String claimantName, String claimReason) {
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimReason = claimReason;
    }

    // auto timestamps
    @PrePersist
    public void onCreate() {
        this.submittedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
