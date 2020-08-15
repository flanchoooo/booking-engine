package com.famethe.payroll.payroll.repository;


import com.famethe.payroll.payroll.domain.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeductionRepository extends JpaRepository<Deduction, Integer> {
    List<Deduction> findByEmployeeId(Integer valueOf);

    Deduction findByLoanId(Integer id);
}
