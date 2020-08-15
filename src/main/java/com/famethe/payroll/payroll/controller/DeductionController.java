package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Deduction;
import com.famethe.payroll.payroll.repository.DeductionRepository;
import com.famethe.payroll.payroll.service.DeductionServiceImpl;
import com.famethe.payroll.payroll.service.StatutoryServiceImpl;
import com.famethe.payroll.payroll.service.statutory.StatutoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "deduction")
public class DeductionController {

    @Autowired
    DeductionServiceImpl deductionService;

    @Autowired
    StatutoryServiceImpl statutoryService;

    @Resource
    DeductionRepository deductionRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Deduction findById(@PathVariable String id) throws EntityNotFoundException {
        return deductionRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable String id) throws EntityNotFoundException {
        deductionRepository.deleteById(Integer.valueOf(id));
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Deduction> findByEmployeeId(@PathVariable String id) throws EntityNotFoundException {
        return deductionRepository.findByEmployeeId(Integer.valueOf(id));
    }

    @GetMapping(value = "/employee/statutory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<StatutoryDTO> getEmployeeStatutory(@PathVariable String id) throws EntityNotFoundException {
        return statutoryService.calculateEmployeeStatutory(Integer.valueOf(id));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody HashMap<String, Object> values) {
        return deductionService.save(values);
    }

}
