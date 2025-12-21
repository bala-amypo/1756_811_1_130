package com.example.demo.service;

import com.example.demo.model.StolenDeviceReport;

import java.util.List;

public interface StolenDeviceService {

    StolenDeviceReport save(StolenDeviceReport report);

    List<StolenDeviceReport> getAll();

    StolenDeviceReport getById(Long id);

    List<StolenDeviceReport> getBySerial(String serialNumber);
}
