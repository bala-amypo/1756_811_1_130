package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FraudAlertRecord;

public interface FraudAlertRecordRepository
        extends JpaRepository<FraudAlertRecord, Long> {

    
    @Override
    Optional<FraudAlertRecord> findById(Long id);

    
    @Override
    List<FraudAlertRecord> findAll();

    
    List<FraudAlertRecord> findByClaimId(Long claimId);

  
    List<FraudAlertRecord> findBySerialNumber(String serialNumber);


    List<FraudAlertRecord> findByResolved(Boolean resolved);
}