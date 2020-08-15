package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Payslip;
import com.famethe.payroll.payroll.repository.BenefitRepository;
import com.famethe.payroll.payroll.repository.PayslipRepository;
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
@RequestMapping(value = "payslip")
public class PayslipController {

    @Resource
    PayslipRepository payslipRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payslip findById(@PathVariable String id) throws EntityNotFoundException {
        return payslipRepository.findById(Integer.valueOf(id)).get();
    }
}
