package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.PayrollBenefit;
import com.famethe.payroll.payroll.domain.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PayslipRepository extends JpaRepository<Payslip, Integer> {
    @Modifying
    @Query(value = "delete from payslip where payroll_id=:payroll_id", nativeQuery = true)
    void deleteByPayrollId(@Param("payroll_id") int payroll_id);

    Payslip findByEmployeeIdAndPayrollId(Integer valueOf, Integer valueOf1);

    @Query(value = "select sum(rate_of_pay) from payslip where employee_id=:employee_id and YEAR(date) = YEAR(CURDATE())", nativeQuery = true)
    BigDecimal calculateYearToDate(@Param("employee_id") Integer employee_id);
}
