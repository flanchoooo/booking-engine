package com.famethe.payroll.payroll.notification;


import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.logging.Logger;

@Service
public class EmailServiceImpl {

    private final static Logger logger = Logger.getLogger(String.valueOf(EmailServiceImpl.class));

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(Company company, String subject, String message) {

        try {
            MimeMessage mineMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mineMimeMessageHelper = new MimeMessageHelper(mineMessage, false, "text/html");
            mineMimeMessageHelper.setTo(company.getEmail());
            mineMimeMessageHelper.setSubject(subject);
            mineMimeMessageHelper.setText(message);
            mineMessage.setContent(message, "text/html");
            javaMailSender.send(mineMessage);
            logger.info("Mail sent to: " + company.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
