package com.example.demo.service.impl;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository repository;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecord save(FraudAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public FraudAlertRecord getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<FraudAlertRecord> getBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecord> getByClaim(Long claimId) {
        return repository.findByClaimId(claimId);
    }

    @Override
    public FraudAlertRecord resolve(Long id) {
        FraudAlertRecord alert = repository.findById(id).orElse(null);
        if (alert != null) {
            alert.setResolved(true);
            return repository.save(alert);
        }
        return null;
    }
}
