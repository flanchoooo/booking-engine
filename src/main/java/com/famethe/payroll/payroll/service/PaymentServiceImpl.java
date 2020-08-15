package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Payment;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.BenefitFactory;
import com.famethe.payroll.payroll.factory.PaymentFactory;
import com.famethe.payroll.payroll.notification.EmailServiceImpl;
import com.famethe.payroll.payroll.repository.BenefitRepository;
import com.famethe.payroll.payroll.repository.PaymentRepository;
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
public class PaymentServiceImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PaymentFactory paymentFactory;

    @Resource
    PaymentRepository paymentRepository;


    @Autowired
    EmailServiceImpl emailService;

    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Payment payment = paymentFactory.getPayment(values);

        try {
            jsonResponse.put(Constants.PAYMENT, paymentRepository.save(payment));
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.PAYMENT_SAVED_SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }

    }

    public  ResponseEntity<?> findByUniqueId(String id) {
        Map<Object, Object> jsonResponse = new HashMap();
        Payment payment = paymentRepository.findByUniqueId(id);

        try {
            jsonResponse.put(Constants.PAYMENT, payment);
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }

    }

    public ResponseEntity<?> update(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Payment payment = paymentRepository.findByUniqueId((String) values.get("unique_id"));
        payment.setStatus("PAID");
        payment = paymentRepository.save(payment);
        //emailService.sendMessageEmail(payment);
        jsonResponse.put(Constants.PAYMENT, payment);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.PAYMENT_SAVED_SUCCESS.getDescription() + " " + payment.getStatus(), jsonResponse);
    }


}
