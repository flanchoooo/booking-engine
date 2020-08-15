package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Payroll;
import com.famethe.payroll.payroll.repository.PayrollBenefitRepository;
import com.famethe.payroll.payroll.repository.PayrollDeductionRepository;
import com.famethe.payroll.payroll.repository.PayrollRepository;
import com.famethe.payroll.payroll.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

@Service
public class PayrollFactory {

    Payroll payroll;

    @Resource
    PayrollBenefitRepository payrollBenefitRepository;

    @Resource
    PayrollDeductionRepository payrollDeductionRepository;

    @Resource
    PayrollRepository payrollRepository;

    @Resource
    PayslipRepository payslipRepository;

    @Transactional
    public Payroll getPayroll(Map<String, Object> values){
        if (values.get("payrollId") != null){
            // delete current payroll and re-run it
            int payrollId = Integer.parseInt(String.valueOf(values.get("payrollId")));
            payrollBenefitRepository.deleteByPayrollId(payrollId);
            payrollDeductionRepository.deleteByPayrollId(payrollId);
            payslipRepository.deleteByPayrollId(payrollId);
            payrollRepository.deleteById(payrollId);
        }
        payroll = new Payroll();
        payroll.setDate(new Timestamp(System.currentTimeMillis()));
        payroll.setPeriod(generatePayrollPeriod());
        payroll.setCompanyId(Integer.parseInt(String.valueOf(values.get("companyId"))));
        try {
            payroll.setCommited(Boolean.parseBoolean(String.valueOf(values.get("committed"))));
        }catch(Exception e){
            payroll.setCommited(false);
        }
        return payroll;
    }

    private String generatePayrollPeriod() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);



        return year + "-" + month + "-";
    }

}
