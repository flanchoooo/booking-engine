package com.famethe.payroll.payroll.controller;


import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Loan;
import com.famethe.payroll.payroll.repository.LoanRepository;
import com.famethe.payroll.payroll.service.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "loan")
public class LoanController {

    @Autowired
    LoanServiceImpl loanService;

    @Resource
    LoanRepository loanRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Loan findById(@PathVariable String id) throws EntityNotFoundException {
        return loanRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable String id) throws EntityNotFoundException {
        loanRepository.deleteById(Integer.valueOf(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HashMap<String, Object> values) {
        return loanService.save(values);
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Loan> findByEmployeeId(@PathVariable String id) throws EntityNotFoundException {
        return loanRepository.findByEmployeeId(Integer.valueOf(id));
    }

}
