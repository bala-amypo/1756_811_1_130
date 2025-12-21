// package com.example.demo.controller;

// import com.example.demo.model.FraudAlertRecord;
// import com.example.demo.service.FraudAlertService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/fraud-alerts")
// public class FraudAlertController {

//     private final FraudAlertService service;

//     public FraudAlertController(FraudAlertService service) {
//         this.service = service;
//     }

//     // POST /api/fraud-alerts
//     @PostMapping
//     public FraudAlertRecord create(@RequestBody FraudAlertRecord alert) {
//         return service.save(alert);
//     }

//     // GET /api/fraud-alerts
//     @GetMapping
//     public List<FraudAlertRecord> getAll() {
//         return service.getAll();
//     }

//     // GET /api/fraud-alerts/{id}
//     @GetMapping("/{id}")
//     public FraudAlertRecord getById(@PathVariable Long id) {
//         return service.getById(id);
//     }

//     // GET /api/fraud-alerts/serial/{serialNumber}
//     @GetMapping("/serial/{serialNumber}")
//     public List<FraudAlertRecord> getBySerial(@PathVariable String serialNumber) {
//         return service.getBySerial(serialNumber);
//     }

//     // GET /api/fraud-alerts/claim/{claimId}
//     @GetMapping("/claim/{claimId}")
//     public List<FraudAlertRecord> getByClaim(@PathVariable Long claimId) {
//         return service.getByClaim(claimId);
//     }

//     // PUT /api/fraud-alerts/{id}/resolve
//     @PutMapping("/{id}/resolve")
//     public FraudAlertRecord resolve(@PathVariable Long id) {
//         return service.resolve(id);
//     }
// }
