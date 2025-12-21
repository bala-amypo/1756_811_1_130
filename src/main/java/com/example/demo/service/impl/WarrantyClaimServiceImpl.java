package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepo,
                                    DeviceOwnershipRecordRepository deviceRepo) {
        this.claimRepo = claimRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public WarrantyClaimRecord save(WarrantyClaimRecord claim) {

        // link device using serial number
        DeviceOwnershipRecord device =
                deviceRepo.findAll()
                        .stream()
                        .filter(d -> d.getSerialNumber().equals(claim.getSerialNumber()))
                        .findFirst()
                        .orElse(null);

        claim.setDevice(device);

        return claimRepo.save(claim);
    }

    @Override
    public List<WarrantyClaimRecord> getAll() {
        return claimRepo.findAll();
    }

    @Override
    public WarrantyClaimRecord getById(Long id) {
        return claimRepo.findById(id).orElse(null);
    }

    @Override
    public List<WarrantyClaimRecord> getBySerial(String serialNumber) {
        return claimRepo.findBySerialNumber(serialNumber);
    }
}
