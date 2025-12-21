package com.example.demo.service;

import com.example.demo.model.WarrantyClaimRecord;

import java.util.List;

public interface WarrantyClaimService {

    WarrantyClaimRecord save(WarrantyClaimRecord claim);

    List<WarrantyClaimRecord> getAll();

    WarrantyClaimRecord getById(Long id);

    List<WarrantyClaimRecord> getBySerial(String serialNumber);
}
