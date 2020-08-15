package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Currency;
import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.service.EmployeeServiceImpl;
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
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Resource
    EmployeeRepository employeeRepository;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findAll() throws EntityNotFoundException {
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee findById(@PathVariable String id) throws EntityNotFoundException {
        return employeeRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/company/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<Employee> findByCompanyId(@PathVariable String id) throws EntityNotFoundException {
        return employeeRepository.findByCompanyId(Integer.valueOf(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody HashMap<String, Object> values) {
        return employeeService.save(values);
    }

}
