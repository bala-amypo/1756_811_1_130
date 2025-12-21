// package com.example.demo.controller;

// import com.example.demo.entity.WarrantyClaimRecord;
// import com.example.demo.service.WarrantyClaimService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/claims")
// public class WarrantyClaimController {

//     private final WarrantyClaimService claimService;

//     public WarrantyClaimController(WarrantyClaimService claimService) {
//         this.claimService = claimService;
//     }

//     @PostMapping
//     public WarrantyClaimRecord submitClaim(
//             @RequestBody WarrantyClaimRecord claim) {
//         return claimService.submitClaim(claim);
//     }

//     @GetMapping
//     public List<WarrantyClaimRecord> getAllClaims() {
//         return claimService.getAllClaims();
//     }

//     @GetMapping("/{id}")
//     public WarrantyClaimRecord getClaimById(@PathVariable Long id) {
//         return claimService.getClaimById(id)
//                 .orElseThrow();
//     }

//     @GetMapping("/serial/{serialNumber}")
//     public List<WarrantyClaimRecord> getClaimsBySerial(
//             @PathVariable String serialNumber) {
//         return claimService.getClaimsBySerial(serialNumber);
//     }

//     @PutMapping("/{id}/status")
//     public WarrantyClaimRecord updateStatus(
//             @PathVariable Long id,
//             @RequestParam String status) {
//         return claimService.updateClaimStatus(id, status);
//     }
// }
