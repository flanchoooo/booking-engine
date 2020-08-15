package com.famethe.payroll.payroll.service;

import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.domain.EmployeeLeave;
import com.famethe.payroll.payroll.enums.ResponseDescription;
import com.famethe.payroll.payroll.enums.ResponseObject;
import com.famethe.payroll.payroll.enums.ResponseStatus;
import com.famethe.payroll.payroll.factory.EmployeeLeaveFactory;
import com.famethe.payroll.payroll.repository.EmployeeLeaveRepository;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeLeaveServiceImpl {

    final long MILLIS_PER_DAY = 1000 * 60 * 60 * 24;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    EmployeeLeaveFactory leaveFactory;

    @Resource
    EmployeeLeaveRepository leaveRepository;

    @Resource
    EmployeeRepository employeeRepository;

    public ResponseEntity<?> save(HashMap<String, Object> values) {
        Map<Object, Object> jsonResponse = new HashMap();
        Employee employee = employeeRepository.findById(Integer.parseInt(String.valueOf(values.get("employeeId")))).get();

        // date Comparison
        if (((String) values.get("type")).equalsIgnoreCase("Vacation Leave")) {
            try {
                long startTime = dateFormat.parse((String) values.get("startDate")).getTime();
                long endTime = dateFormat.parse((String) values.get("endDate")).getTime();

                long diff = endTime - startTime;
                long diffdays = (diff / (24 * 60 * 60 * 1000) + 1);
                if (diffdays > employee.getLeaveBalance()) {
                    return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), ResponseDescription.LEAVE_BALANCE_ERROR.getDescription());
                } else {
                    if ((values.get("id")) == null) {
                        employee.setLeaveBalance(employee.getLeaveBalance() - diffdays);
                    } else {
                        EmployeeLeave empLeave = leaveRepository.findById(Integer.parseInt(String.valueOf(values.get("id")))).get();

                        startTime = empLeave.getStartDate().getTime();
                        endTime = empLeave.getEndDate().getTime();

                        diff = endTime - startTime;
                        diffdays = (diff / (24 * 60 * 60 * 1000) + 1);

                        employee.setLeaveBalance(employee.getLeaveBalance() + diffdays);

                        startTime = dateFormat.parse((String) values.get("startDate")).getTime();
                        endTime = dateFormat.parse((String) values.get("endDate")).getTime();

                        diff = endTime - startTime;
                        diffdays = (diff / (24 * 60 * 60 * 1000) + 1);
                        if (diffdays > employee.getLeaveBalance()) {
                            return new ResponseObject().returnResponseBody(ResponseStatus.GENERAL_ERROR.getStatus(), ResponseDescription.LEAVE_BALANCE_ERROR.getDescription());
                        }else{
                            employee.setLeaveBalance(employee.getLeaveBalance() - diffdays);
                        }
                    }
                    employeeRepository.save(employee);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        EmployeeLeave leave = leaveFactory.getLeave(values);
        leaveRepository.save(leave);
        jsonResponse.put(Constants.LEAVE, leave);
        return new ResponseObject().returnResponseBody(ResponseStatus.SUCCESS.getStatus(), ResponseDescription.LEAVE_CONFIG_SUCCESS.getDescription(), jsonResponse);
    }

    public void deleteById(Integer id) {
        EmployeeLeave empLeave = leaveRepository.findById(id).get();
        if (empLeave.getType().equalsIgnoreCase("Vacation Leave")) {
            long startTime = empLeave.getStartDate().getTime();
            long endTime = empLeave.getEndDate().getTime();

            long diff = endTime - startTime;
            long diffdays = (diff / (24 * 60 * 60 * 1000) + 1);

            Employee employee = employeeRepository.findById(empLeave.getEmployeeId()).get();
            employee.setLeaveBalance(employee.getLeaveBalance() + diffdays);
            employeeRepository.save(employee);
        }
        leaveRepository.delete(empLeave);
    }
}
