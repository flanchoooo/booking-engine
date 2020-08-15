package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Payment;
import com.famethe.payroll.payroll.repository.PaymentRepository;
import com.famethe.payroll.payroll.utils.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class PaymentFactory {

    Payment payment;

    @Resource
    PaymentRepository paymentRepository;

    public Payment getPayment(Map<String, Object> values){
        if (values.get("id") != null){
            payment = paymentRepository.findById(Integer.parseInt(String.valueOf(values.get("id")))).get();
        }else{
            payment = new Payment();
            payment.setDate(TimeUtil.getTimeStamp());
        }
        payment.setCompanyId((Integer) values.get("companyId"));
        payment.setPackageId((Integer) values.get("packageId"));
        payment.setAmount(new BigDecimal(String.valueOf(values.get("amount"))));
        payment.setEmail((String) values.get("email"));
        payment.setDescription((String) values.get("description"));
        payment.setType(((String) values.get("type")).toUpperCase());
        payment.setPollUrl((String) values.get("pollUrl"));
        payment.setUniqueId((String) values.get("uniqueId"));
        payment.setStatus((String) values.get("status"));
        return payment;
    }

}
