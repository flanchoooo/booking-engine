package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Deduction;
import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.domain.Payroll;
import com.famethe.payroll.payroll.domain.PayrollDeduction;
import com.famethe.payroll.payroll.service.statutory.StatutoryDTO;
import org.springframework.stereotype.Service;

@Service
public class PayrollDeductionFactory {

    PayrollDeduction payrollDeduction;

    public PayrollDeduction getPayrollDeduction(Employee employee, Payroll payroll, Deduction deduction){
        payrollDeduction = new PayrollDeduction();
        payrollDeduction.setCompanyContribution(deduction.getCompanyContribution());
        payrollDeduction.setDescription(deduction.getDescription());
        payrollDeduction.setEmployeeContribution(deduction.getEmployeeContribution());
        payrollDeduction.setPayrollId(payroll.getId());
        payrollDeduction.setEmployeeId(employee.getId());
        return payrollDeduction;
    }

    public PayrollDeduction getPayrollDeduction(Employee employee, Payroll payroll, StatutoryDTO statutoryDTO){
        payrollDeduction = new PayrollDeduction();
        payrollDeduction.setCompanyContribution(statutoryDTO.getCompanyContribution());
        payrollDeduction.setDescription(statutoryDTO.getDescription());
        payrollDeduction.setEmployeeContribution(statutoryDTO.getEmployeeContribution());
        payrollDeduction.setPayrollId(payroll.getId());
        payrollDeduction.setEmployeeId(employee.getId());
        return payrollDeduction;
    }
}
