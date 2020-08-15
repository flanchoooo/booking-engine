package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Deduction;
import com.famethe.payroll.payroll.domain.Loan;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.DeductionFactory;
import com.famethe.payroll.payroll.repository.DeductionRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class DeductionServiceImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DeductionFactory deductionFactory;

    @Resource
    DeductionRepository deductionRepository;

    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Deduction deduction= deductionFactory.getDeduction(values);
        deductionRepository.save(deduction);
        jsonResponse.put(Constants.DEDUCTION, deduction);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.DEDUCTION_ACTIVATION_SUCCESS.getDescription(), jsonResponse);
    }


    public Deduction saveLoanDeduction(Loan loan){
        Deduction deduction = deductionRepository.findByLoanId(loan.getId());
        if (deduction != null){
            deductionRepository.delete(deduction);
        }
        deduction = deductionFactory.getDeduction(loan);
        deductionRepository.save(deduction);
        return deduction;
    }

}
