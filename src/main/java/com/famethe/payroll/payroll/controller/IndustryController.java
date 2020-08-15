package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Industry;
import com.famethe.payroll.payroll.repository.IndustryRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "industry")
public class IndustryController {

    @Resource
    IndustryRepository industryRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Industry> findAll() throws EntityNotFoundException {
        return industryRepository.findAll();
    }

}
