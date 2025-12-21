// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "fraud_alerts")
// public class FraudAlertRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String alertType;
//     private String severity;
//     private boolean resolved;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "warranty_claim_id", nullable = false)
//     private WarrantyClaimRecord claim;

//     // -------- getters & setters --------

//     public Long getId() {
//         return id;
//     }

//     public String getAlertType() {
//         return alertType;
//     }

//     public void setAlertType(String alertType) {
//         this.alertType = alertType;
//     }

//     public String getSeverity() {
//         return severity;
//     }

//     public void setSeverity(String severity) {
//         this.severity = severity;
//     }

//     public boolean isResolved() {
//         return resolved;
//     }

//     public void setResolved(boolean resolved) {
//         this.resolved = resolved;
//     }

//     public WarrantyClaimRecord getClaim() {
//         return claim;
//     }

//     public void setClaim(WarrantyClaimRecord claim) {
//         this.claim = claim;
//     }
// }
