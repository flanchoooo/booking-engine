package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.repository.BenefitRepository;
import com.famethe.payroll.payroll.service.BenefitServiceImpl;
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
@RequestMapping(value = "benefit")
public class BenefitController {

    @Autowired
    BenefitServiceImpl benefitService;

    @Resource
    BenefitRepository benefitRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Benefit findById(@PathVariable String id) throws EntityNotFoundException {
        return benefitRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable String id) throws EntityNotFoundException {
        benefitRepository.deleteById(Integer.valueOf(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HashMap<String, Object> values) {
        return benefitService.save(values);
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Benefit> findByEmployeeId(@PathVariable String id) throws EntityNotFoundException {
        return benefitRepository.findByEmployeeId(Integer.valueOf(id));
    }
}
