package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StolenDeviceReport;

public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReport, Long> {

    Optional<StolenDeviceReport> findBySerialNumber(String serialNumber);

    boolean existsBySerialNumber(String serialNumber);
}
