package com.famethe.payroll.payroll.repository;

import com.famethe.payroll.payroll.domain.Rates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatesRepository extends JpaRepository<Rates, Integer> {

    @Query(value = "select * from rates where tax_band_id=:tax_band_id", nativeQuery = true)
    List<Rates> findByTaxBandId(@Param("tax_band_id") Integer taxBandId);
}
