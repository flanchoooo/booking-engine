package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Integer> {
}
