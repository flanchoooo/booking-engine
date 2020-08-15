package com.famethe.payroll.payroll.service.statutory;

import com.famethe.payroll.payroll.domain.*;
import com.famethe.payroll.payroll.repository.CompanyRepository;
import com.famethe.payroll.payroll.repository.PayeeTaxTableRepository;
import com.famethe.payroll.payroll.repository.RatesRepository;
import com.famethe.payroll.payroll.repository.TaxBandRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Paye calculated using tax tables
 * Aids Levy
 *
 * 100% contributed by employee
 *
 */


@Service
public class ZimraServiceImpl {

    @Resource
    PayeeTaxTableRepository payeeTaxTableRepository;

    @Resource
    TaxBandRepository taxBandRepository;

    @Resource
    RatesRepository ratesRepository;

    public StatutoryDTO calculatePayee(Company company, Employee employee) {
        PayeeTaxTable payeeTaxTable = payeeTaxTableRepository.findByCurrencyId(company.getCurrencyId());
        TaxBand taxBand = taxBandRepository.findByCycleAndTaxTable(company.getPayrollCycle(), payeeTaxTable.getId());

        List<Rates> rates = ratesRepository.findByTaxBandId(taxBand.getId());
        for (Rates rate : rates) {
            if ((employee.getRateOfPay().compareTo(rate.getMin()) >= 0 && employee.getRateOfPay().compareTo(rate.getUpper()) <= 0) || (rate.getMin().compareTo(rate.getUpper()) == 0 && employee.getRateOfPay().compareTo(rate.getUpper()) >= 0)) {
                return new StatutoryDTO(Constants.PAYEE, employee.getRateOfPay().multiply(rate.getRate().divide(new BigDecimal(100))).subtract(rate.getDeduction()), new BigDecimal(0));
            }
        }

        return new StatutoryDTO(Constants.PAYEE);
    }

    public StatutoryDTO calculateAidsLevy(Company company, StatutoryDTO payeeDTO) {
        PayeeTaxTable payeeTaxTable = payeeTaxTableRepository.findByCurrencyId(company.getCurrencyId());
        return new StatutoryDTO(Constants.AIDS, payeeDTO.getEmployeeContribution().multiply(payeeTaxTable.getAidsLevy().divide(new BigDecimal(100))), new BigDecimal(0));
    }

}
