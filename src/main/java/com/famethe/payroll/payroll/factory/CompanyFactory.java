package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Map;

@Service
public class CompanyFactory {

    Company company = null;

    @Resource
    CompanyRepository companyRepository;


    public Company getCompany(Map<String, Object> values){
        if (values.get("id") == null){
            company = new Company();
            company.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
            company.setActive(true);
            company.setRegistrationComplete(false);
        }else{
            company = companyRepository.findById((Integer)values.get("id")).get();
        }
        company.setName((String) values.get("name"));
        company.setEmail((String) values.get("email"));
        company.setAddress((String) values.get("address"));
        company.setCity((String) values.get("city"));
        company.setSuburb((String) values.get("suburb"));
        company.setCountry((String) values.get("country"));
        company.setPhone((String) values.get("phone"));
        company.setPayrollCycle((String) values.get("payrollCycle"));
        try {
            company.setOperatingDay(Integer.parseInt((String) values.get("operatingDay")));
        }catch(Exception e){

        }

        try {
            company.setIndustryId(Integer.parseInt(String.valueOf(values.get("industryId"))));
        }catch (Exception e){

        }

        try {
            company.setCurrencyId(Integer.parseInt(String.valueOf(values.get("currencyId"))));
        }catch (Exception e){

        }

        try {
            company.setPackageId(Integer.parseInt(String.valueOf(values.get("packageId"))));
        }catch (Exception e){

        }

        return company;
    }

}
