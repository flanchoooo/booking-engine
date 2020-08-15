package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Payment;
import com.famethe.payroll.payroll.repository.PaymentRepository;
import com.famethe.payroll.payroll.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    PaymentServiceImpl paymentService;

    @Resource
    PaymentRepository paymentRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> findAll() throws EntityNotFoundException {
        return paymentRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payment findById(@PathVariable String id) throws EntityNotFoundException {
        return paymentRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/company/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> findByCompanyId(@PathVariable String id) throws EntityNotFoundException {
        return paymentRepository.findByCompanyId(Integer.valueOf(id));
    }

    @GetMapping(value = "/uniqueId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByUniqueId(@PathVariable String id) throws EntityNotFoundException {
        return paymentService.findByUniqueId(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HashMap<String, Object> values) {
        return paymentService.save(values);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody HashMap<String, Object> values) {
        return paymentService.update(values);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable String id) throws EntityNotFoundException {
        paymentRepository.deleteById(Integer.valueOf(id));
    }

}
