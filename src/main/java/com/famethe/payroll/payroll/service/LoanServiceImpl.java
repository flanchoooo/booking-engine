package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Loan;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.LoanFactory;
import com.famethe.payroll.payroll.repository.LoanRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoanServiceImpl {

    @Autowired
    LoanFactory loanFactory;

    @Autowired
    DeductionServiceImpl deductionService;

    @Resource
    LoanRepository loanRepository;

    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Loan loan= loanFactory.getLoan(values);
        loanRepository.save(loan);
        deductionService.saveLoanDeduction(loan);
        jsonResponse.put(Constants.LOAN, loan);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.LOAN_CONFIG_SUCCESS.getDescription(), jsonResponse);
    }

    public BigDecimal getLoanInstallment(Loan loan) {
        // todo : calculate loan installment
        return new BigDecimal(0);
    }

    public BigDecimal getLoanBalance(Loan loan) {
        // todo : calculate loan balance after paid installments
        return new BigDecimal(0);
    }
}
