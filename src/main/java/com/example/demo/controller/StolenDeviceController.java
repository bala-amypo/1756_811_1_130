package com.example.demo.controller;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.service.StolenDeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stolen-devices")
public class StolenDeviceController {

    private final StolenDeviceService service;

    public StolenDeviceController(StolenDeviceService service) {
        this.service = service;
    }

    @PostMapping
    public StolenDeviceReport create(@RequestBody StolenDeviceReport report) {
        return service.save(report);
    }

    @GetMapping
    public List<StolenDeviceReport> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StolenDeviceReport getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<StolenDeviceReport> getBySerial(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }
}
