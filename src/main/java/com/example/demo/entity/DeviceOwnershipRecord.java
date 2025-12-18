package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.*;

@Entity
public class DeviceOwnershipRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String serialNumber;
    private String ownerName;
    private String ownerEmail;
    private LocalDate purchaseDate;
    private LocalDate warrantyExpiration;
    private Bool active;

    public DeviceOwnershipRecord(String serialNumber, String ownerName, String ownerEmail, LocalDate purchaseDate, LocalDate warrantyExpiration, Bool active ){
        this.id = id;
        this.serialNumber = serialNumber;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiration  = warrantyExpiration;
        this.active = active;
    }

    public DeviceOwnershipRecord(){

    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public String getOwnerName(){
        return this.ownerNamer;
    }

    public void setOwnerEmail(String ownerEmail){
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerEmail(){
        return this.ownerEmail;
    }

    public void setPurchaseDate(LocalDate purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getPurchaseDate(){
        return this.purchaseDate;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration){
        this.warrantyExpiration = warrantyExpiration;
    }

    public LocalDate getWarrantyExpiration(){
        return this.warrantyExpiration;
    }

    public void setActive(Bool active){
        this.active = active;
    }

    public Bool getActive(){
        return this.active;
    }
}