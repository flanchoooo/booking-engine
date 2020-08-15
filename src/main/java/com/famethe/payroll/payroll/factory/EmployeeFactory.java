package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.utils.Constants;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class EmployeeFactory {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private Employee employee;

    @Resource
    EmployeeRepository employeeRepository;

    public Employee getEmployee(Map<String, Object> values){
        if (values.get("id") == null){
            employee = new Employee();
            employee.setActive(true);
            employee.setStatus(Constants.ACTIVE);
        }else{
            employee = employeeRepository.findById(Integer.parseInt((String)values.get("id"))).get();
            employee.setActive(Boolean.parseBoolean((String) values.get("active")));
        }

        employee.setEmployeeNumber(generateEmployeeNumber((Integer) values.get("companyId")));
        employee.setCompanyId((Integer) values.get("companyId"));
        employee.setFirstname((String) values.get("firstname"));
        employee.setLastname((String) values.get("lastname"));
        employee.setNationalId((String) values.get("nationalId"));
        employee.setNationality((String) values.get("nationality"));
        employee.setGender((String) values.get("gender"));
        try {
            employee.setDateOfBirth(new Timestamp(dateFormat.parse((String)values.get("dateOfBirth")).getTime()));
        } catch (ParseException | NullPointerException e) {
            employee.setDateOfBirth(null);
        }
        employee.setAddress((String) values.get("address"));
        employee.setSuburb((String) values.get("suburb"));
        employee.setCity((String) values.get("city"));
        employee.setCountry((String) values.get("country"));
        employee.setPhone((String) values.get("phone"));
        employee.setEmail((String) values.get("email"));
        employee.setNokName((String) values.get("nokName"));
        employee.setNokAddress((String) values.get("nokAddress"));
        employee.setNokPhone((String) values.get("nokPhone"));
        employee.setNokRelationship((String) values.get("nokRelationship"));
        employee.setMaritalStatus((String) values.get("maritalStatus"));
        employee.setBankAccountNumber((String) values.get("bankAccountNumber"));
        employee.setBankAccountName((String) values.get("bankAccountName"));
        employee.setBankName((String) values.get("bankName"));
        employee.setBranch((String) values.get("branch"));
        try {
            employee.setDateOfEngagement(new Timestamp(dateFormat.parse((String)values.get("dateOfEngagement")).getTime()));
        } catch (ParseException |NullPointerException e) {
            employee.setDateOfBirth(null);
        }
        try {
            employee.setContractExpiryDate(new Timestamp(dateFormat.parse((String)values.get("contractExpiryDate")).getTime()));
        } catch (NullPointerException | ParseException e) {
            employee.setDateOfBirth(null);
        }
        employee.setContractType((String) values.get("contractType"));
        employee.setDepartment((String) values.get("department"));
        employee.setPosition((String) values.get("position"));
        employee.setLeaveEntitlement(Double.parseDouble(String.valueOf(values.get("leaveEntitlement"))));
        employee.setLeaveBalance((double) 0);
        try {
            employee.setRateOfPay(new BigDecimal((String) values.get("rateOfPay")));
        }catch (NullPointerException e){
            employee.setRateOfPay(null);
        }
        try{
            employee.setTaxCreditsId((Integer) values.get("taxCredits"));
        }catch(Exception e){
            employee.setTaxCreditsId(null);
        }
        return employee;
    }

    private String generateEmployeeNumber(int companyId){
        int count = employeeRepository.countByCompanyId(companyId) + 1;

        String countStr = "";

        if (count < 10){
            countStr = "00" + count;
        }else if (count < 100){
            countStr = "0" + count;
        }

        return countStr;
    }

}
