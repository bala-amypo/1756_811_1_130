package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "device_ownership_records",
    uniqueConstraints = @UniqueConstraint(columnNames = "serial_number")
)
public class DeviceOwnershipRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private String ownerName;

    private String ownerEmail;

    private LocalDate purchaseDate;

    @Column(nullable = false)
    private LocalDate warrantyExpiration;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // 🔹 Relationships
    @OneToMany(mappedBy = "device")
    private List<WarrantyClaimRecord> warrantyClaims;

    @OneToMany(mappedBy = "device")
    private List<StolenDeviceReport> stolenReports;

    // 🔹 No-args constructor
    public DeviceOwnershipRecord() {}

    // 🔹 Core fields constructor
    public DeviceOwnershipRecord(
            String serialNumber,
            String ownerName,
            String ownerEmail,
            LocalDate purchaseDate,
            LocalDate warrantyExpiration
    ) {
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiration = warrantyExpiration;
        this.active = true;
    }

    // 🔹 Auto timestamps & defaults
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ✅ Recommended (safe for JPA & JSON)
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ✅ ADDED — relationship getters/setters

    public List<WarrantyClaimRecord> getWarrantyClaims() {
        return warrantyClaims;
    }

    public void setWarrantyClaims(List<WarrantyClaimRecord> warrantyClaims) {
        this.warrantyClaims = warrantyClaims;
    }

    public List<StolenDeviceReport> getStolenReports() {
        return stolenReports;
    }

    public void setStolenReports(List<StolenDeviceReport> stolenReports) {
        this.stolenReports = stolenReports;
    }
}
