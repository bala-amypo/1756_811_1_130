package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository reportRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository reportRepo,
                                   DeviceOwnershipRecordRepository deviceRepo) {
        this.reportRepo = reportRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport save(StolenDeviceReport report) {

        DeviceOwnershipRecord device =
                deviceRepo.findAll()
                        .stream()
                        .filter(d -> d.getSerialNumber().equals(report.getSerialNumber()))
                        .findFirst()
                        .orElse(null);

        report.setDevice(device);

        return reportRepo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAll() {
        return reportRepo.findAll();
    }

    @Override
    public StolenDeviceReport getById(Long id) {
        return reportRepo.findById(id).orElse(null);
    }

    @Override
    public List<StolenDeviceReport> getBySerial(String serialNumber) {
        return reportRepo.findBySerialNumber(serialNumber);
    }
}
