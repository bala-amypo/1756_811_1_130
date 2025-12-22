package com.example.demo.controller;

import com.example.demo.entity.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public WarrantyClaimRecord submitClaim(
            @RequestBody WarrantyClaimRecord claim
    ) {
        return service.submitClaim(claim);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return service.getClaimById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
    }

    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getBySerial(
            @PathVariable String serialNumber
    ) {
        return service.getClaimsBySerial(serialNumber);
    }

 
    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return service.updateClaimStatus(id, status);
    }
}
