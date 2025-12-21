package com.example.demo.service.impl;

import com.example.demo.entity.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    // Register device
    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {

        // PDF rule: unique serial number
        if (repository.existsBySerialNumber(device.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number already exists");
        }

        return repository.save(device);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    // Activate / Deactivate device
    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {

        DeviceOwnershipRecord device = repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Device not found"));

        device.setActive(active);
        return repository.save(device);
    }
}
