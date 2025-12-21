package com.example.demo.controller;

import com.example.demo.entity.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService stolenService;

    public StolenDeviceController(StolenDeviceService stolenService) {
        this.stolenService = stolenService;
    }

    @PostMapping
    public StolenDeviceReport reportStolen(
            @RequestBody StolenDeviceReport report) {
        return stolenService.reportStolen(report);
    }

    @GetMapping
    public List<StolenDeviceReport> getAllReports() {
        return stolenService.getAllReports();
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getReportById(@PathVariable Long id) {
        return stolenService.getReportById(id)
                .orElseThrow();
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getReportsBySerial(
            @PathVariable String serialNumber) {
        return stolenService.getReportsBySerial(serialNumber);
    }
}
