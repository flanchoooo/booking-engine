package com.famethe.payroll.payroll.controller;

import com.famethe.payroll.payroll.domain.Package;
import com.famethe.payroll.payroll.domain.Pricing;
import com.famethe.payroll.payroll.repository.PackageRepository;
import com.famethe.payroll.payroll.repository.PricingRepository;
import com.famethe.payroll.payroll.service.SubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionServiceImpl subscriptionService;

    @Resource
    PackageRepository packageRepository;

    @Resource
    PricingRepository pricingRepository;

    @GetMapping(value = "/package", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Package> findAll() throws EntityNotFoundException {
        return packageRepository.findAll();
    }

    @GetMapping(value = "/package/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Package findPackageById(@PathVariable String id) throws EntityNotFoundException {
        return packageRepository.findById(Integer.parseInt(id)).get();
    }

    @GetMapping(value = "/package/pricing/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pricing> findPricingByPackage(@PathVariable String id) throws EntityNotFoundException {
        return pricingRepository.findByPackageId(Integer.parseInt(id));
    }

    @GetMapping(value = "/package/pricing/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pricing findPricingByid(@PathVariable String id) throws EntityNotFoundException {
        return pricingRepository.findById(Integer.parseInt(id)).get();
    }

}
