// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(name = "warranty_claim_records")
// public class WarrantyClaimRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String serialNumber;
//     private String claimantName;
//     private String claimantEmail;
//     private String claimReason;

//     private String status = "PENDING";
//     private LocalDateTime submittedAt;
//     private LocalDateTime createdAt;

//     @ManyToOne
//     @JoinColumn(name = "device_id")
//     private DeviceOwnershipRecord device;

//     @OneToMany(mappedBy = "claim")
//     private List<FraudAlertRecord> alerts;

//     public WarrantyClaimRecord() {}

//     @PrePersist
//     public void onCreate() {
//         this.submittedAt = LocalDateTime.now();
//         this.createdAt = LocalDateTime.now();
//     }

//     // ===== REQUIRED GETTERS / SETTERS =====

//     public Long getId() {
//         return id;
//     }

//     public String getSerialNumber() {
//         return serialNumber;
//     }

//     public void setSerialNumber(String serialNumber) {
//         this.serialNumber = serialNumber;
//     }

//     public void setDevice(DeviceOwnershipRecord device) {
//         this.device = device;
//     }
// }
