package com.famethe.payroll.payroll.factory;

import com.famethe.payroll.payroll.domain.EmployeeLeave;
import com.famethe.payroll.payroll.repository.EmployeeLeaveRepository;
import com.famethe.payroll.payroll.utils.Constants;
import com.famethe.payroll.payroll.utils.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class EmployeeLeaveFactory {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Resource
    EmployeeLeaveRepository leaveRepository;

    private EmployeeLeave leave;

    public EmployeeLeave getLeave(Map<String, Object> values) {
        if (values.get("id") == null) {
            leave = new EmployeeLeave();
        } else {
            leave = leaveRepository.findById(Integer.parseInt(String.valueOf(values.get("id")))).get();
        }

        try {
            leave.setStartDate(new Timestamp(dateFormat.parse((String) values.get("startDate")).getTime()));
        } catch (ParseException | NullPointerException e) {
            leave.setStartDate(null);
        }

        try {
            leave.setEndDate(new Timestamp(dateFormat.parse((String) values.get("endDate")).getTime()));
        } catch (ParseException | NullPointerException e) {
            leave.setEndDate(null);
        }

        leave.setType((String) values.get("type"));
        leave.setDescription((String) values.get("description"));
        leave.setEmployeeId(Integer.parseInt(String.valueOf(values.get("employeeId"))));

        // date comparison for leave status
        try {
            if (TimeUtil.getTimeStamp().before(leave.getStartDate())) {
                leave.setStatus(Constants.PENDING);
                leave.setDeletable(false);
            } else if (TimeUtil.getTimeStamp().after(leave.getStartDate()) && TimeUtil.getTimeStamp().before(leave.getEndDate())) {
                leave.setStatus(Constants.ACTIVE);
                leave.setDeletable(false);
            } else if (TimeUtil.getTimeStamp().after(leave.getEndDate())) {
                leave.setStatus(Constants.COMPLETE);
                if (values.get("id") == null) {
                    leave.setDeletable(true);
                }else{
                    leave.setDeletable(false);
                }
            }
        } catch (Exception e) {
            leave.setStatus(Constants.UNKNOWN);
        }
        return leave;
    }

}
