package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Benefit;
import com.famethe.payroll.payroll.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {

}
