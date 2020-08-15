package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.EmployeeFactory;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl {

    @Resource
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeFactory employeeFactory;

    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();

        Employee employee = null;
        if (values.get("id") == null) {
            employee = employeeRepository.findByNationalIdAndActive((String) values.get("nationalId"), true);
            if (employee != null) {
                return new ResponseObject().returnResponseBody(ResponseStatus.ENTITY_ALREADY_EXISTS.getStatus(), ResponseDescription.EMPLOYEE_ENTITY_ALREADY_EXISTS.getDescription(), jsonResponse);
            }
        }
        employee = employeeFactory.getEmployee(values);

        try {
            employeeRepository.save(employee);
            jsonResponse.put(Constants.EMPLOYEE, employee);
            return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.EMPLOYEE_REG_SUCCESS.getDescription(), jsonResponse);
        }catch(DataIntegrityViolationException exc){
            return new ResponseObject().returnResponseBody(ResponseStatus.SQL_ERROR.getStatus(), exc.getRootCause().getLocalizedMessage());
        }
    }

}
