package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stolen_device_reports")
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unique serial number
    @Column(unique = true)
    private String serialNumber;

    private String reportedBy;
    private String details;

    private LocalDateTime reportDate;

    // MANY REPORTS → ONE DEVICE
    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceOwnershipRecord device;

    // no-args constructor
    public StolenDeviceReport() {}

    // core fields constructor
    public StolenDeviceReport(String serialNumber, String reportedBy) {
        this.serialNumber = serialNumber;
        this.reportedBy = reportedBy;
    }

    // auto timestamp
    @PrePersist
    public void onCreate() {
        this.reportDate = LocalDateTime.now();
    }

    // getters and setters
}
