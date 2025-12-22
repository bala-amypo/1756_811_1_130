package com.example.demo.controller;

import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }


    @PostMapping
    public StolenDeviceReport reportStolen(
            @RequestBody StolenDeviceReport report
    ) {
        return service.reportStolen(report);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return service.getAllReports();
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return service.getReportById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerial(
            @PathVariable String serialNumber
    ) {
        return service.getReportsBySerial(serialNumber);
    }
}
