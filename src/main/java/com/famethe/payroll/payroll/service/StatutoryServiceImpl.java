package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.repository.CompanyRepository;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.service.statutory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class StatutoryServiceImpl {

    @Autowired
    NssaServiceImpl nssaService;

    @Autowired
    SdfServiceImpl sdfService;

    @Autowired
    ZimdefServiceImpl zimdefService;

    @Autowired
    ZimraServiceImpl zimraService;

    @Resource
    CompanyRepository companyRepository;

    @Resource
    EmployeeRepository employeeRepository;

    public ArrayList<StatutoryDTO> calculateEmployeeStatutory(Integer employeeId){
        ArrayList<StatutoryDTO> response = new ArrayList();
        Employee employee = employeeRepository.findById(employeeId).get();
        Company company = companyRepository.findById(employee.getCompanyId()).get();

        response.add(nssaService.calculateNssa(employee));
        response.add(nssaService.calculateWcif(company));
        response.add(sdfService.calculateSdf(company));
        response.add(zimdefService.calculateZimdef(company));

        StatutoryDTO payeeDTO = zimraService.calculatePayee(company, employee);
        response.add(payeeDTO);

        response.add(zimraService.calculateAidsLevy(company, payeeDTO));

        return response;
    }
}
