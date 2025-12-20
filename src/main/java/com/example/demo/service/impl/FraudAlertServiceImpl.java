package com.example.demo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FraudAlertRecord;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertService;

@Service
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRecordRepository fraudAlertRepository;

    
    public FraudAlertServiceImpl(FraudAlertRecordRepository fraudAlertRepository) {
        this.fraudAlertRepository = fraudAlertRepository;
    }


    @Override
    public FraudAlertRecord createAlert(FraudAlertRecord alert) {
        return fraudAlertRepository.save(alert);
    }


    @Override
    public FraudAlertRecord getAlertById(Long id) {
    return fraudAlertRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Request not found"));
    }


    @Override
    public FraudAlertRecord resolveAlert(Long id) {
        FraudAlertRecord alert = fraudAlertRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));

        alert.setResolved(true);
        return fraudAlertRepository.save(alert);
    }


    @Override
    public List<FraudAlertRecord> getAlertsBySerial(String serialNumber) {
        return fraudAlertRepository.findBySerialNumber(serialNumber);
    }


    @Override
    public List<FraudAlertRecord> getAlertsByClaim(Long claimId) {
        return fraudAlertRepository.findByClaimId(claimId);
    }


    @Override
    public List<FraudAlertRecord> getAllAlerts() {
        return fraudAlertRepository.findAll();
    }
}