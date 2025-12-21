// package com.example.demo.service.impl;

// import com.example.demo.model.DeviceOwnershipRecord;
// import com.example.demo.repository.DeviceOwnershipRecordRepository;
// import com.example.demo.service.DeviceOwnershipService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

//     private final DeviceOwnershipRecordRepository repository;

//     public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public DeviceOwnershipRecord save(DeviceOwnershipRecord device) {
//         return repository.save(device);   // OUTPUT OBJECT
//     }

//     @Override
//     public List<DeviceOwnershipRecord> getAll() {
//         return repository.findAll();      // OUTPUT LIST
//     }

//     @Override
//     public DeviceOwnershipRecord getById(Long id) {
//         return repository.findById(id).orElse(null);
//     }

//     @Override
// public DeviceOwnershipRecord getBySerial(String serialNumber) {
//     return repository.findAll()
//             .stream()
//             .filter(d -> d.getSerialNumber().equals(serialNumber))
//             .findFirst()
//             .orElse(null);
// }

// @Override
// public DeviceOwnershipRecord updateStatus(Long id, boolean active) {
//     DeviceOwnershipRecord device = repository.findById(id).orElse(null);
//     if (device != null) {
//         device.setActive(active);
//         return repository.save(device);
//     }
//     return null;
// }

// }
