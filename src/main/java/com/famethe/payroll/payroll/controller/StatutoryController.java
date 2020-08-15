package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Industry;
import com.famethe.payroll.payroll.domain.Pension;
import com.famethe.payroll.payroll.domain.StandardDevelopmentFund;
import com.famethe.payroll.payroll.domain.TaxBand;
import com.famethe.payroll.payroll.repository.IndustryRepository;
import com.famethe.payroll.payroll.repository.PensionRepository;
import com.famethe.payroll.payroll.repository.SdfRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "statutory")
public class StatutoryController {

    @Resource
    PensionRepository pensionRepository;

    @Resource
    IndustryRepository industryRepository;

    @Resource
    SdfRepository sdfRepository;

    @GetMapping(value = "/pension", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pension> getPensionRates() throws EntityNotFoundException {
        return pensionRepository.findAll();
    }

    @GetMapping(value = "/wcif/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Industry findWcif(@PathVariable String id) throws EntityNotFoundException {
        return industryRepository.findById(Integer.parseInt(id)).get();
    }

    @GetMapping(value = "/sdf", produces = MediaType.APPLICATION_JSON_VALUE)
    public StandardDevelopmentFund findSdf() throws EntityNotFoundException {
        return sdfRepository.findAll().get(0);
    }
}
