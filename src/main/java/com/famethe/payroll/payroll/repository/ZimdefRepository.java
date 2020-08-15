package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.StandardDevelopmentFund;
import com.famethe.payroll.payroll.domain.Zimdef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZimdefRepository extends JpaRepository<Zimdef, Integer> {

    @Query(value = "select * from zimdef order by id desc limit 1 ", nativeQuery = true)
    Zimdef findRecentZimdef();

}
