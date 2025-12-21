package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import java.util.List;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord save(DeviceOwnershipRecord device);

    List<DeviceOwnershipRecord> getAll();

    DeviceOwnershipRecord getById(Long id);
}
