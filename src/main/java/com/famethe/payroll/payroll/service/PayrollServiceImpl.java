package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.*;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.PayrollBenefitFactory;
import com.famethe.payroll.payroll.factory.PayrollDeductionFactory;
import com.famethe.payroll.payroll.factory.PayrollFactory;
import com.famethe.payroll.payroll.factory.PayslipFactory;
import com.famethe.payroll.payroll.repository.*;
import com.famethe.payroll.payroll.service.statutory.StatutoryDTO;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PayrollServiceImpl {

    @Autowired
    PayrollFactory payrollFactory;

    @Resource
    EmployeeRepository employeeRepository;

    @Resource
    BenefitRepository benefitRepository;

    @Resource
    PayrollBenefitRepository payrollBenefitRepository;

    @Resource
    PayrollDeductionRepository payrollDeductionRepository;

    @Resource
    DeductionRepository deductionRepository;

    @Autowired
    PayrollBenefitFactory payrollBenefitFactory;

    @Autowired
    PayrollDeductionFactory payrollDeductionFactory;


    @Autowired
    StatutoryServiceImpl calculateEmployeeStatutory;

    @Resource
    PayrollRepository payrollRepository;

    @Autowired
    PayslipFactory payslipFactory;

    @Resource
    PayslipRepository payslipRepository;


    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();

        Payroll payroll = payrollFactory.getPayroll(values);
        payrollRepository.save(payroll);

        // employees by company id
        List<Employee> employees = employeeRepository.findByCompanyId(Integer.parseInt(String.valueOf(values.get("companyId"))));
        for (Employee e : employees) {

            ArrayList<StatutoryDTO> statures =  calculateEmployeeStatutory.calculateEmployeeStatutory(e.getId());
            for (StatutoryDTO stature : statures) {
                PayrollDeduction payrollDeduction = payrollDeductionFactory.getPayrollDeduction(e,payroll, stature);
                payrollDeductionRepository.save(payrollDeduction);
            }

            List<Benefit> benefits = benefitRepository.findByEmployeeId(e.getId());
            for (Benefit benefit : benefits) {
                PayrollBenefit payrollBenefit = payrollBenefitFactory.getPayrollBenefit(e, payroll,  benefit);
                payrollBenefitRepository.save(payrollBenefit);
            }

            List<Deduction> deductions = deductionRepository.findByEmployeeId(e.getId());
            for (Deduction deduction : deductions) {
                PayrollDeduction payrollDeduction = payrollDeductionFactory.getPayrollDeduction(e, payroll, deduction);
                payrollDeductionRepository.save(payrollDeduction);
            }

            payslipRepository.save(payslipFactory.getPayslip(e, payroll));

        }

        jsonResponse.put(Constants.PAYROLL, payroll);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.PAYROLL_GENERATION_SUCCESS.getDescription(), jsonResponse);
    }


}
