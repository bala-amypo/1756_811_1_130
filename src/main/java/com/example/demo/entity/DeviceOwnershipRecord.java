// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(name = "device_ownership_records")
// public class DeviceOwnershipRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String serialNumber;

//     private String ownerName;
//     private String ownerEmail;
//     private LocalDate purchaseDate;
//     private LocalDate warrantyExpiration;

//     private Boolean active = true;
//     private LocalDateTime createdAt;

//     @OneToMany(mappedBy = "device")
//     private List<WarrantyClaimRecord> claims;

//     @OneToMany(mappedBy = "device")
//     private List<StolenDeviceReport> stolenReports;

//     public DeviceOwnershipRecord() {}

//     @PrePersist
//     public void onCreate() {
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

//     public void setId(Long id) {
//         this.id = id;
//     }

//     // getter for active
// public Boolean getActive() {
//     return active;
// }

// // setter for active
// public void setActive(Boolean active) {
//     this.active = active;
// }

// }
