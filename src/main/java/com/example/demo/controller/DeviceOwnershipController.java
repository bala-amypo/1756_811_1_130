package com.example.demo.controller;

import com.example.demo.entity.DeviceOwnershipRecord;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService service;

    public DeviceOwnershipController(DeviceOwnershipService service) {
        this.service = service;
    }

    
    @PostMapping
    public DeviceOwnershipRecord registerDevice(
            @RequestBody DeviceOwnershipRecord device
    ) {
        return service.registerDevice(device);
    }

    @GetMapping
    public List<DeviceOwnershipRecord> getAllDevices() {
        return service.getAllDevices();
    }

    @GetMapping("/{id}")
    public DeviceOwnershipRecord getById(@PathVariable Long id) {
        return service.getAllDevices()
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @GetMapping("/serial/{serialNumber}")
    public DeviceOwnershipRecord getBySerial(
            @PathVariable String serialNumber
    ) {
        return service.getBySerial(serialNumber)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

   
    @PutMapping("/{id}/status")
    public DeviceOwnershipRecord updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active
    ) {
        return service.updateDeviceStatus(id, active);
    }
}
