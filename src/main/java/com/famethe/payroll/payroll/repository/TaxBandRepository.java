package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.TaxBand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Supplier;

@Repository
public interface TaxBandRepository extends JpaRepository<TaxBand, Integer> {

    @Query(value = "select * from tax_band where name like :name and tax_table_id=:tax_table_id", nativeQuery = true)
    TaxBand findByCycleAndTaxTable(@Param("name") String name, @Param("tax_table_id") Integer tax_table_id);

    @Query(value = "select * from tax_band where tax_table_id=:tax_table_id", nativeQuery = true)
    List<TaxBand> findByTaxTableId(@Param("tax_table_id") Integer tax_table_id);
}
