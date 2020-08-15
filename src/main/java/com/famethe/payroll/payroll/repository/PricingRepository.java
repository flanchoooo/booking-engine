package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Package;
import com.famethe.payroll.payroll.domain.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Integer> {

    List<Pricing> findByPackageId(int parseInt);
}
