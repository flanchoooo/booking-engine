package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.StandardDevelopmentFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SdfRepository extends JpaRepository<StandardDevelopmentFund, Integer> {

    @Query(value = "select * from standard_development_fund order by id desc limit 1 ", nativeQuery = true)
    StandardDevelopmentFund findRecentSdf();

}
