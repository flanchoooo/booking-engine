package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.PayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PayrollDeductionRepository extends JpaRepository<PayrollDeduction, Integer> {

    @Modifying
    @Query(value = "delete from payroll_deduction where payroll_id=:payroll_id", nativeQuery = true)
    void deleteByPayrollId(@Param("payroll_id") int payroll_id);

    List<PayrollDeduction> findByEmployeeIdAndPayrollId(Integer valueOf, Integer valueOf1);
}
