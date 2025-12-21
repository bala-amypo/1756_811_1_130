package com.example.demo.controller;

import com.example.demo.entity.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    // 🔒 ADMIN (security can be added later)
    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<FraudRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/{id}")
    public FraudRule getRuleById(@PathVariable Long id) {
        return service.getAllRules()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Rule not found"));
    }

    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return service.getActiveRules();
    }

    // 🔒 ADMIN
    @PutMapping("/{id}")
    public FraudRule updateRule(
            @PathVariable Long id,
            @RequestBody FraudRule rule
    ) {
        return service.updateRule(id, rule);
    }
}
