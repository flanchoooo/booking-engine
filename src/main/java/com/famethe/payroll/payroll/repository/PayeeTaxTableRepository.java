package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.PayeeTaxTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayeeTaxTableRepository extends JpaRepository<PayeeTaxTable, Integer> {

    // order by id desc to get most recent tax table applicable
    @Query(value = "select * from payee_tax_table where currency_id=:currency_id order by id desc limit 1", nativeQuery = true)
    PayeeTaxTable findByCurrencyId(@Param("currency_id") Integer currencyId);
}
