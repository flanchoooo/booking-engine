package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Integer> {
    List<EmployeeLeave> findByEmployeeId(Integer valueOf);

    @Query(value = "select * from employee_leave where status like 'PENDING' or status'ACTIVE'", nativeQuery = true)
    List<EmployeeLeave> findPendingProcessing();
}
