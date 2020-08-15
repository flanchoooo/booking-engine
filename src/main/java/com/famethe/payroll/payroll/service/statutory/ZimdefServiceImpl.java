package com.famethe.payroll.payroll.service.statutory;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Zimdef;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.repository.ZimdefRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class ZimdefServiceImpl  {

    @Resource
    EmployeeRepository employeeRepository;

    @Resource
    ZimdefRepository zimdefRepository;

    /*
     * ZIMDEF is paid by the employer
     * */
    public StatutoryDTO calculateZimdef(Company company) {
        BigDecimal wageBill = employeeRepository.calculateWageBill(company.getId());
        Zimdef zimdef = zimdefRepository.findRecentZimdef();
        return new StatutoryDTO(Constants.ZIMDEF, new BigDecimal(0), wageBill.multiply(zimdef.getRate().divide(new BigDecimal(100))));
    }

}
