package com.famethe.payroll.payroll.service.statutory;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.StandardDevelopmentFund;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.repository.SdfRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class SdfServiceImpl {

    @Resource
    EmployeeRepository employeeRepository;

    @Resource
    SdfRepository sdfRepository;

    /*
     * SDF is paid by the employer
     * */
    public StatutoryDTO calculateSdf(Company company) {
        // get total wage bill
        BigDecimal wageBill = employeeRepository.calculateWageBill(company.getId());
        StandardDevelopmentFund fund = sdfRepository.findRecentSdf();
        return new StatutoryDTO(Constants.SDF, new BigDecimal(0), wageBill.multiply(fund.getRate().divide(new BigDecimal(100))));
    }

}
