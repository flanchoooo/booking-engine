package com.famethe.payroll.payroll.cron;

import com.famethe.payroll.payroll.domain.Employee;
import com.famethe.payroll.payroll.domain.EmployeeLeave;
import com.famethe.payroll.payroll.repository.EmployeeLeaveRepository;
import com.famethe.payroll.payroll.repository.EmployeeRepository;
import com.famethe.payroll.payroll.utils.Constants;
import com.famethe.payroll.payroll.utils.TimeUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class EmployeeLeaveCronTask {

    @Resource
    EmployeeLeaveRepository leaveRepository;

    @Scheduled(cron = "0 0 0 1/1 * ?")
    public void employeeLeaveStatusChecker(){

        List<EmployeeLeave> leaveList = leaveRepository.findPendingProcessing();
        for (EmployeeLeave employeeLeave : leaveList){
            try {
                if (TimeUtil.getTimeStamp().after(employeeLeave.getStartDate()) && TimeUtil.getTimeStamp().before(employeeLeave.getEndDate())) {
                    if (employeeLeave.getStatus().equals(Constants.PENDING)) {
                        employeeLeave.setStatus(Constants.ACTIVE);
                        employeeLeave.setDeletable(false);
                        leaveRepository.save(employeeLeave);
                    }
                } else if (TimeUtil.getTimeStamp().after(employeeLeave.getEndDate())) {
                    if (employeeLeave.getStatus().equals(Constants.PENDING) || employeeLeave.getStatus().equals(Constants.ACTIVE)) {
                        employeeLeave.setStatus(Constants.COMPLETE);
                        leaveRepository.save(employeeLeave);
                    }
                }
            } catch (Exception e) {
                employeeLeave.setStatus(Constants.UNKNOWN);
                leaveRepository.save(employeeLeave);
            }

        }

    }

}
