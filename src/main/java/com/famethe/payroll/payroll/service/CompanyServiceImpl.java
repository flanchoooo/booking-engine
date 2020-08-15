package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.domain.User;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.CompanyFactory;
import com.famethe.payroll.payroll.factory.UserFactory;
import com.famethe.payroll.payroll.notification.EmailServiceImpl;
import com.famethe.payroll.payroll.notification.MessageTypes.CompanyRegistrationMessage;
import com.famethe.payroll.payroll.repository.CompanyRepository;
import com.famethe.payroll.payroll.repository.UserRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CompanyServiceImpl {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    CompanyRepository companyRepository;


    @Autowired
    CompanyFactory companyFactory;

    @Autowired
    UserFactory userFactory;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    CompanyRegistrationMessage companyRegistrationMessage;


    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();

        // register company
        Company company = companyFactory.getCompany(values);
        try {
            companyRepository.save(company);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }

        // save user
        String url = "http://localhost:9001/api/register";

        // create request body
        JSONObject request = new JSONObject();
        request.put("username", values.get("username"));
        request.put("password", values.get("password"));
        request.put("passwordConfirm", values.get("password"));
        request.put("email", values.get("email"));
        request.put("companyId", company.getId());
        request.put("platformId", Constants.PLATFORM_ID);
        request.put("accessId", Constants.ACCESS_ID);

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

        // send request and parse result
        RestTemplate restTemplate = new RestTemplate();

        // send POST request
        ResponseEntity<String> response = null;
        logger.info("GATEWAY REQUEST " + request.toString());
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        }catch (Exception e){
            companyRepository.delete(company);
            return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), ResponseDescription.HTTP_GENERAL_ERROR.getDescription(), jsonResponse);
        }
        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                JSONObject jsonObject = new JSONObject(response.getBody());
                System.out.println("GATEWAY RESPONSE" + response.getBody());

                if (jsonObject.get("status").toString().equals("200")){
                    emailService.sendEmail(company, companyRegistrationMessage.getSubject(), companyRegistrationMessage.getMessage());
                    return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.COMPANY_REG_SUCCESS.getDescription(), jsonResponse);
                }else{
                    companyRepository.delete(company);
                    return new ResponseObject().returnResponseBody(jsonObject.get("status"), (String) jsonObject.get("message"), jsonResponse);
                }
            } catch (JSONException err) {
                err.printStackTrace();
                return new ResponseObject().returnResponseBody(response.getStatusCode(), ResponseDescription.HTTP_GENERAL_ERROR.getDescription(), jsonResponse);
            }
        }else{
            return new ResponseObject().returnResponseBody(response.getStatusCode(), ResponseDescription.HTTP_GENERAL_ERROR.getDescription(), jsonResponse);
        }
    }

    public ResponseEntity<?> update(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Company company = companyFactory.getCompany(values);
        try {
            jsonResponse.put(Constants.COMPANY, company);
            company.setRegistrationComplete(true);
            companyRepository.save(company);
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.COMPANY_ACTIVATION_SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }
    }
}
