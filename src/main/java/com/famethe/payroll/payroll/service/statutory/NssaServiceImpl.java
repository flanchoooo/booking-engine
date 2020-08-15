package com.famethe.payroll.payroll.service.statutory;

import com.famethe.payroll.payroll.domain.*;
import com.famethe.payroll.payroll.repository.*;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class NssaServiceImpl {

    @Resource
    PensionRepository pensionRepository;

    @Resource
    EmployeeRepository employeeRepository;

    @Resource
    IndustryRepository industryRepository;

    /*
    * Nssa is contributed by both the employee and the employer
    * */

    public StatutoryDTO calculateNssa(Employee employee) {

        List<Pension> pensions = pensionRepository.findAll();

        for (Pension pension : pensions) {
            if ((employee.getRateOfPay().compareTo(pension.getMin()) >= 0 && employee.getRateOfPay().compareTo(pension.getMax()) <= 0) || (pension.getMin().compareTo(pension.getMax()) == 0 && employee.getRateOfPay().compareTo(pension.getMax()) >= 0)){
                return new StatutoryDTO(Constants.NSSA, (employee.getRateOfPay().multiply(pension.getRate().divide(new BigDecimal(100)))).add(pension.getFixed()), (employee.getRateOfPay().multiply(pension.getRate().divide(new BigDecimal(100)))).add(pension.getFixed()));
            }
        }

        return new StatutoryDTO(Constants.NSSA);
    }

    public StatutoryDTO calculateWcif(Company company) {
        BigDecimal wageBill = employeeRepository.calculateWageBill(company.getId());
        Industry industry = industryRepository.findById(company.getIndustryId()).get();
        return new StatutoryDTO(Constants.WCIF, new BigDecimal(0), wageBill.multiply(industry.getWcifRate().divide(new BigDecimal(100))));
    }


}
