package com.example.demo.controller;

import com.example.demo.entity.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService fraudAlertService;
    private final WarrantyClaimService warrantyClaimService;

    public FraudAlertController(
            FraudAlertService fraudAlertService,
            WarrantyClaimService warrantyClaimService
    ) {
        this.fraudAlertService = fraudAlertService;
        this.warrantyClaimService = warrantyClaimService;
    }

 
    @PostMapping
    public FraudAlertRecord createAlert(@RequestBody FraudAlertRecord alert) {


        alert.setClaim(
                warrantyClaimService.getClaimById(alert.getClaimId())
                        .orElseThrow(() -> new RuntimeException("Claim not found"))
        );

        return fraudAlertService.createAlert(alert);
    }

    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return fraudAlertService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public FraudAlertRecord getAlertById(@PathVariable Long id) {
        return fraudAlertService.getAllAlerts()
                .stream()
                .filter(alert -> alert.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> getAlertsBySerial(
            @PathVariable String serialNumber
    ) {
        return fraudAlertService.getAlertsBySerial(serialNumber);
    }

    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> getAlertsByClaim(
            @PathVariable Long claimId
    ) {
        return fraudAlertService.getAlertsByClaim(claimId);
    }

 
    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolveAlert(@PathVariable Long id) {
        return fraudAlertService.resolveAlert(id);
    }
}
