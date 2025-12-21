package com.example.demo.controller;

import com.example.demo.entity.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService fraudAlertService;

    public FraudAlertController(FraudAlertService fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }

    // POST /api/fraud-alerts (ADMIN)
    @PostMapping
    public FraudAlertRecord createAlert(
            @RequestBody FraudAlertRecord alert) {
        return fraudAlertService.createAlert(alert);
    }

    // GET /api/fraud-alerts
    @GetMapping
    public List<FraudAlertRecord> getAllAlerts() {
        return fraudAlertService.getAllAlerts();
    }

    // GET /api/fraud-alerts/{id}
    @GetMapping("/{id}")
    public FraudAlertRecord getAlertById(@PathVariable Long id) {
        return fraudAlertService.resolveAlert(id);
    }

    // GET /api/fraud-alerts/serial/{serialNumber}
    @GetMapping("/serial/{serialNumber}")
    public List<FraudAlertRecord> getAlertsBySerial(
            @PathVariable String serialNumber) {
        return fraudAlertService.getAlertsBySerial(serialNumber);
    }

    // GET /api/fraud-alerts/claim/{claimId}
    @GetMapping("/claim/{claimId}")
    public List<FraudAlertRecord> getAlertsByClaim(
            @PathVariable Long claimId) {
        return fraudAlertService.getAlertsByClaim(claimId);
    }

    // PUT /api/fraud-alerts/{id}/resolve (ADMIN)
    @PutMapping("/{id}/resolve")
    public FraudAlertRecord resolveAlert(@PathVariable Long id) {
        return fraudAlertService.resolveAlert(id);
    }
}
