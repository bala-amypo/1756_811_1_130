package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/fraud-alerts")
@Tag(name = "Fraud Alert")
public class FraudAlertController {

    private final FraudAlertService fraudAlertService;

    
    public FraudAlertController(FraudAlertService fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }


    @PostMapping
    public ResponseEntity<FraudAlertRecord> createAlert(
            @RequestBody FraudAlertRecord alert) {
        return ResponseEntity.ok(fraudAlertService.createAlert(alert));
    }


    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(fraudAlertService.getAllAlerts());
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertRecord> getAlertById(
            @PathVariable Long id) {
        return ResponseEntity.ok(fraudAlertService.getAlertById(id));
    }


    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(
                fraudAlertService.getAlertsBySerial(serialNumber)
        );
    }


    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsByClaim(
            @PathVariable Long claimId) {
        return ResponseEntity.ok(
                fraudAlertService.getAlertsByClaim(claimId)
        );
    }

    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<FraudAlertRecord> resolveAlert(
            @PathVariable Long id) {
        return ResponseEntity.ok(fraudAlertService.resolveAlert(id));
    }
}