package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Deduction;
import com.famethe.payroll.payroll.domain.Loan;
import com.famethe.payroll.payroll.repository.BenefitRepository;
import com.famethe.payroll.payroll.repository.DeductionRepository;
import com.famethe.payroll.payroll.service.LoanServiceImpl;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class DeductionFactory {

    private Deduction deduction;

    @Resource
    DeductionRepository deductionRepository;

    @Autowired
    LoanServiceImpl loanService;

    public Deduction getDeduction(Map<String, Object> values){
        if (values.get("id") == null){
            deduction = new Deduction();
        }else{
            deduction = deductionRepository.findById(Integer.parseInt(String.valueOf(values.get("id")))).get();
        }

        deduction.setCompanyContribution(new BigDecimal(String.valueOf(values.get("companyContribution"))));
        deduction.setEmployeeContribution(new BigDecimal(String.valueOf(values.get("employeeContribution"))));
        deduction.setDescription(String.valueOf(values.get("description")));
        deduction.setEmployeeId(Integer.parseInt(String.valueOf(values.get("employeeId"))));
        return deduction;
    }

    public Deduction getDeduction(Loan loan) {
        deduction = new Deduction();

        deduction.setCompanyContribution(new BigDecimal(0));
        deduction.setEmployeeContribution(loanService.getLoanInstallment(loan));
        deduction.setDescription("Loan: " + loan.getPurpose());
        deduction.setEmployeeId(loan.getEmployeeId());
        deduction.setLoanId(loan.getId());

        return deduction;
    }
}
