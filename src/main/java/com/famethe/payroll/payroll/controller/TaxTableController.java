package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.PayeeTaxTable;
import com.famethe.payroll.payroll.domain.Payslip;
import com.famethe.payroll.payroll.domain.Rates;
import com.famethe.payroll.payroll.domain.TaxBand;
import com.famethe.payroll.payroll.repository.PayeeTaxTableRepository;
import com.famethe.payroll.payroll.repository.PayslipRepository;
import com.famethe.payroll.payroll.repository.RatesRepository;
import com.famethe.payroll.payroll.repository.TaxBandRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "taxtable")
public class TaxTableController {

    @Resource
    PayeeTaxTableRepository payeeTaxTableRepository;

    @Resource
    TaxBandRepository taxBandRepository;

    @Resource
    RatesRepository ratesRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PayeeTaxTable> getTaxTable() throws EntityNotFoundException {
        return payeeTaxTableRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PayeeTaxTable findById(@PathVariable String id) throws EntityNotFoundException {
        return payeeTaxTableRepository.findById(Integer.valueOf(id)).get();
    }

    @GetMapping(value = "/taxband/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaxBand> findTaxBandByTaxTable(@PathVariable String id) throws EntityNotFoundException {
        return taxBandRepository.findByTaxTableId(Integer.valueOf(id));
    }

    @GetMapping(value = "/taxband/rate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rates> findRateByTaxBand(@PathVariable String id) throws EntityNotFoundException {
        return ratesRepository.findByTaxBandId(Integer.valueOf(id));
    }

}
