package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.domain.Payroll;
import com.famethe.payroll.payroll.domain.PayrollBenefit;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class PayrollBenefitFactory {

    PayrollBenefit payrollBenefit;

    public PayrollBenefit getPayrollBenefit(Employee employee, Payroll payroll, Benefit benefit){
        payrollBenefit = new PayrollBenefit();
        payrollBenefit.setPayrollId(payroll.getId());
        payrollBenefit.setAmount(benefit.getAmount());
        payrollBenefit.setDescription(benefit.getDescription());
        payrollBenefit.setEmployeeId(employee.getId());
        return  payrollBenefit;
    }

}
