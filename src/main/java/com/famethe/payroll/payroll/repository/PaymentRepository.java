package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Company;
import com.famethe.payroll.payroll.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByUniqueId(String id);

    List<Payment> findByCompanyId(Integer valueOf);
}
