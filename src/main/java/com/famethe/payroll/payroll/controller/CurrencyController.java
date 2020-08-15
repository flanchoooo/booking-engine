package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Currency;
import com.famethe.payroll.payroll.domain.Industry;
import com.famethe.payroll.payroll.repository.CurrencyRepository;
import com.famethe.payroll.payroll.repository.IndustryRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "currency")
public class CurrencyController {

    @Resource
    CurrencyRepository currencyRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Currency> findAll() throws EntityNotFoundException {
        return currencyRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Currency findById(@PathVariable String id) throws EntityNotFoundException {
        return currencyRepository.findById(Integer.valueOf(id)).get();
    }


}
