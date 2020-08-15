package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Deduction;
import com.famethe.payroll.payroll.domain.EmployeeLeave;
import com.famethe.payroll.payroll.repository.EmployeeLeaveRepository;
import com.famethe.payroll.payroll.service.EmployeeLeaveServiceImpl;
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
@RequestMapping(value = "leave")
public class EmployeeLeaveController {

    @Autowired
    EmployeeLeaveServiceImpl leaveService;

    @Resource
    EmployeeLeaveRepository leaveRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeLeave findById(@PathVariable String id) throws EntityNotFoundException {
        return leaveRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable String id) throws EntityNotFoundException {
        leaveService.deleteById(Integer.valueOf(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HashMap<String, Object> values) {
        return leaveService.save(values);
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeLeave> findByEmployeeId(@PathVariable String id) throws EntityNotFoundException {
        return leaveRepository.findByEmployeeId(Integer.valueOf(id));
    }

}
