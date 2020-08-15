package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
    @Query(value = "select * from payroll where company_id=:company_id and commited = 0 order by id desc ", nativeQuery = true)
    Payroll findByCompanyId(@Param("company_id") Integer company_id);
}
