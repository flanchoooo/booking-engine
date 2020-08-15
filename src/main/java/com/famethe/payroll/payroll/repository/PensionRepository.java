package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Pension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionRepository extends JpaRepository<Pension, Integer> {
}
