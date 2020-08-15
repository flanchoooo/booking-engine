package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.BenefitFactory;
import com.famethe.payroll.payroll.repository.BenefitRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class BenefitServiceImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BenefitFactory benefitFactory;

    @Resource
    BenefitRepository benefitRepository;

    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Benefit benefit = benefitFactory.getBenefit(values);
        benefitRepository.save(benefit);
        jsonResponse.put(Constants.BENEFIT, benefit);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.BENEFIT_ACTIVATION_SUCCESS.getDescription(), jsonResponse);
    }
}
