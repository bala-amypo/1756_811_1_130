// package com.example.demo.controller;

// import com.example.demo.entity.DeviceOwnershipRecord;
// import com.example.demo.service.DeviceOwnershipService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/devices")
// public class DeviceOwnershipController {

//     private final DeviceOwnershipService service;

//     public DeviceOwnershipController(DeviceOwnershipService service) {
//         this.service = service;
//     }

//     // POST /api/devices
//     @PostMapping
//     public DeviceOwnershipRecord registerDevice(
//             @RequestBody DeviceOwnershipRecord device) {
//         return service.registerDevice(device);
//     }

//     // GET /api/devices
//     @GetMapping
//     public List<DeviceOwnershipRecord> getAllDevices() {
//         return service.getAllDevices();
//     }

//     // GET /api/devices/{id}
//     @GetMapping("/{id}")
//     public DeviceOwnershipRecord getDeviceById(@PathVariable Long id) {
//         return service.getById(id)
//                 .orElseThrow(() ->
//                         new RuntimeException("Device not found"));
//     }

//     // GET /api/devices/serial/{serialNumber}
//     @GetMapping("/serial/{serialNumber}")
//     public DeviceOwnershipRecord getDeviceBySerial(
//             @PathVariable String serialNumber) {
//         return service.getBySerial(serialNumber)
//                 .orElseThrow(() ->
//                         new RuntimeException("Device not found"));
//     }

//     // PUT /api/devices/{id}/status
//     @PutMapping("/{id}/status")
//     public DeviceOwnershipRecord updateStatus(
//             @PathVariable Long id,
//             @RequestParam boolean active) {
//         return service.updateDeviceStatus(id, active);
//     }
// }
