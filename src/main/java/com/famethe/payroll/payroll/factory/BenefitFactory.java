package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.repository.BenefitRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class BenefitFactory {

    private Benefit benefit;

    @Resource
    BenefitRepository benefitRepository;

    public Benefit getBenefit(Map<String, Object> values){
        if (values.get("id") == null){
            benefit = new Benefit();
        }else{
            benefit = benefitRepository.findById(Integer.parseInt(String.valueOf(values.get("id")))).get();
        }

        benefit.setAmount(new BigDecimal(String.valueOf(values.get("amount"))));
        benefit.setDescription(String.valueOf(values.get("description")));
        benefit.setEmployeeId(Integer.parseInt(String.valueOf(values.get("employeeId"))));

        return benefit;
    }

}
