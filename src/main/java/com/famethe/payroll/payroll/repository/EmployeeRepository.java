package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select count(*) from employee where active=true and company_id=:company_id", nativeQuery = true)
    int countByCompanyId(@Param("company_id") int company_id);

    Employee findByNationalIdAndActive(String nationalId, boolean b);

    List<Employee> findByCompanyId(Integer companyId);

    @Query(value = "select sum(rate_of_pay) from employee where company_id=:company_id", nativeQuery = true)
    BigDecimal calculateWageBill(@Param("company_id") Integer companyId);
}
