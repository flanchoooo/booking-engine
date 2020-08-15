package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Loan;
import com.famethe.payroll.payroll.repository.LoanRepository;
import com.famethe.payroll.payroll.service.LoanServiceImpl;
import com.famethe.payroll.payroll.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class LoanFactory {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Resource
    LoanRepository loanRepository;

    @Autowired
    LoanServiceImpl loanService;

    Loan loan;

    public Loan getLoan(Map<String, Object> values){
        if (values.get("id") == null){
            loan = new Loan();
        }else{
            loan = loanRepository.findById(Integer.parseInt(String.valueOf(values.get("id")))).get();
        }

        loan.setBalance(loanService.getLoanBalance(loan));
        loan.setType((String) values.get("type"));
        loan.setPurpose((String) values.get("purpose"));
        loan.setAmount(new BigDecimal(String.valueOf(values.get("amount"))));
        loan.setInstallmentPeriod(Integer.parseInt(String.valueOf(values.get("installmentPeriod"))));
        loan.setInterest(new BigDecimal(String.valueOf(values.get("interest"))));
        loan.setEmployeeId(Integer.parseInt(String.valueOf(values.get("employeeId"))));

        try {
            loan.setDate(new Timestamp(dateFormat.parse((String) values.get("date")).getTime()));
        } catch (ParseException | NullPointerException e) {
            loan.setDate(TimeUtil.getTimeStamp());
        }

        return loan;
    }
}
