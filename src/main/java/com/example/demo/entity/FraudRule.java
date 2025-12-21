package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "fraud_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = "rule_code")
)
public class FraudRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_code", nullable = false, unique = true)
    private String ruleCode;

    @Column(name = "rule_type", nullable = false)
    private String ruleType;

    private String description;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // 🔹 No-args constructor
    public FraudRule() {}

    // 🔹 Core fields constructor
    public FraudRule(String ruleCode, String ruleType, String description) {
        this.ruleCode = ruleCode;
        this.ruleType = ruleType;
        this.description = description;
        this.active = true;
    }

    // 🔹 Auto-populate createdAt
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    // ✅ Added (important for updates & JSON mapping)
    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ✅ Added (safe, optional but recommended)
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
