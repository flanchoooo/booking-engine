package com.famethe.payroll.payroll.controller;


import com.famethe.payroll.payroll.domain.*;
import com.famethe.payroll.payroll.repository.*;
import com.famethe.payroll.payroll.service.LoanServiceImpl;
import com.famethe.payroll.payroll.service.PayrollServiceImpl;
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
@RequestMapping(value = "payroll")
public class PayrollController {

    @Autowired
    PayrollServiceImpl payrollService;

    @Resource
    PayrollRepository payrollRepository;


    @Resource
    PayrollDeductionRepository payrollDeductionRepository;

    @Resource
    PayrollBenefitRepository payrollBenefitRepository;

    @Resource
    PayslipRepository payslipRepository;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payroll findPayrolloptById(@PathVariable String id) throws EntityNotFoundException {
        return payrollRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/company/active/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payroll findById(@PathVariable String id) throws EntityNotFoundException {
        return payrollRepository.findByCompanyId(Integer.valueOf(id));
    }

    @GetMapping(value = "/deduction/employee/{employeeId}/{payrollId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PayrollDeduction> findDeductionsByPayrollId(@PathVariable String employeeId, @PathVariable String payrollId) throws EntityNotFoundException {
        return payrollDeductionRepository.findByEmployeeIdAndPayrollId(Integer.valueOf(employeeId), Integer.valueOf(payrollId));
    }

    @GetMapping(value = "/benefit/employee/{employeeId}/{payrollId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PayrollBenefit> findDBenefitsByPayrollId(@PathVariable String employeeId, @PathVariable String payrollId) throws EntityNotFoundException {
        return payrollBenefitRepository.findByEmployeeIdAndPayrollId(Integer.valueOf(employeeId), Integer.valueOf(payrollId));
    }

    @GetMapping(value = "/payslip/employee/{employeeId}/{payrollId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Payslip findPayslipByPayrollId(@PathVariable String employeeId, @PathVariable String payrollId) throws EntityNotFoundException {
        return payslipRepository.findByEmployeeIdAndPayrollId(Integer.valueOf(employeeId), Integer.valueOf(payrollId));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> runPayroll(@RequestBody HashMap<String, Object> values) throws EntityNotFoundException {
        return payrollService.save(values);
    }

}
