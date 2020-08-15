package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.domain.Payroll;
import com.famethe.payroll.payroll.domain.Payslip;
import com.famethe.payroll.payroll.repository.PayslipRepository;
import com.famethe.payroll.payroll.utils.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class PayslipFactory {

    @Resource
    PayslipRepository payslipRepository;


    Payslip payslip;

    public Payslip getPayslip(Employee employee, Payroll payroll){
        payslip = new Payslip();
        payslip.setEmployeeId(employee.getId());
        payslip.setRateOfPay(employee.getRateOfPay());
        payslip.setPayrollId(payroll.getId());
        payslip.setYearToDate(calculateYearToDate(employee));
        payslip.setDate(TimeUtil.getTimeStamp());
        return payslip;
    }

    private BigDecimal calculateYearToDate(Employee employee) {
        BigDecimal y2d = payslipRepository.calculateYearToDate(employee.getId());

        return null;
    }

}
