package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Loan;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.LoanFactory;
import com.famethe.payroll.payroll.repository.LoanRepository;
import com.famethe.payroll.payroll.repository.PackageRepository;
import com.famethe.payroll.payroll.repository.PricingRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubscriptionServiceImpl {

    @Resource
    PackageRepository packageRepository;

    @Resource
    PricingRepository pricingRepository;

    public BigDecimal getLoanInstallment(Loan loan) {
        // todo : calculate loan installment
        return new BigDecimal(0);
    }

    public BigDecimal getLoanBalance(Loan loan) {
        // todo : calculate loan balance after paid installments
        return new BigDecimal(0);
    }
}
