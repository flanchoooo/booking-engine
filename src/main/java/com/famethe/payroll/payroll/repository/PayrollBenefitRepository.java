package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.PayrollBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PayrollBenefitRepository extends JpaRepository<PayrollBenefit, Integer> {

    @Modifying
    @Query(value = "delete from payroll_benefit where payroll_id=:payroll_id", nativeQuery = true)
    void deleteByPayrollId(@Param("payroll_id") int payroll_id);
    List<PayrollBenefit> findByEmployeeIdAndPayrollId(Integer valueOf, Integer valueOf1);
}
