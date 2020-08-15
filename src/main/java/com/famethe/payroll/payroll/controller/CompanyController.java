package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.repository.CompanyRepository;
import com.famethe.payroll.payroll.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping(value = "company")
public class CompanyController {

    @Resource
    CompanyRepository companyRepository;

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company findById(@PathVariable String id) throws EntityNotFoundException {
        return companyRepository.findById(Integer.valueOf(id)).get();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody HashMap<String, Object> values) {
        return companyService.save(values);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody HashMap<String, Object> values) {
        return companyService.update(values);
    }
}
