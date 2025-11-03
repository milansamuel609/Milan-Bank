package com.milan.atm_application.controller;

import com.milan.atm_application.model.ATMRequest;
import com.milan.atm_application.model.ATMResponse;
import com.milan.atm_application.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atm")
@CrossOrigin(origins = "*")
public class ATMController {

    @Autowired
    private ATMService atmService;

    @PostMapping("/deposit")
    public ResponseEntity<ATMResponse> deposit(@RequestBody ATMRequest request) {
        return ResponseEntity.ok(atmService.deposit(request.getAmount()));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<ATMResponse> withdraw(@RequestBody ATMRequest request) {
        return ResponseEntity.ok(atmService.withdraw(request.getAmount()));
    }

    @GetMapping("/balance")
    public ResponseEntity<ATMResponse> getBalance() {
        return ResponseEntity.ok(atmService.getBalance());
    }

    @PostMapping("/initialize")
    public ResponseEntity<ATMResponse> initialize(@RequestBody ATMRequest request) {
        return ResponseEntity.ok(atmService.initialize(request.getAmount()));
    }

    @GetMapping("/status")
    public ResponseEntity<ATMResponse> checkStatus() {
        return ResponseEntity.ok(atmService.checkStatus());
    }
}