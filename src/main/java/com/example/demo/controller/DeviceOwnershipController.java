package com.example.demo.controller;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public DeviceOwnershipRecord create(@RequestBody DeviceOwnershipRecord device) {
        return service.save(device);
    }

    // READ ALL
    @GetMapping
    public List<DeviceOwnershipRecord> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public DeviceOwnershipRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ✅ READ BY SERIAL NUMBER
    @GetMapping("/serial/{serialNumber}")
    public DeviceOwnershipRecord getBySerial(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }

    // ✅ ACTIVATE / DEACTIVATE DEVICE
    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateStatus(id, active);
    }
}
