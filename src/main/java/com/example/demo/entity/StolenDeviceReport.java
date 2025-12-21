// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "stolen_device_reports")
// public class StolenDeviceReport {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String serialNumber;

//     private String reportedBy;
//     private String details;
//     private LocalDateTime reportDate;

//     @ManyToOne
//     @JoinColumn(name = "device_id")
//     private DeviceOwnershipRecord device;

//     public StolenDeviceReport() {}

//     @PrePersist
//     public void onCreate() {
//         this.reportDate = LocalDateTime.now();
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
