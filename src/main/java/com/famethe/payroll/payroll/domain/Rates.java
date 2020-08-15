package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Rates {
    private Integer id;
    private Integer taxBandId;
    private BigDecimal min;
    private BigDecimal upper;
    private BigDecimal rate;
    private BigDecimal deduction;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tax_band_id", nullable = false)
    public Integer getTaxBandId() {
        return taxBandId;
    }

    public void setTaxBandId(Integer taxBandId) {
        this.taxBandId = taxBandId;
    }

    @Basic
    @Column(name = "min", nullable = true, precision = 2)
    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    @Basic
    @Column(name = "upper", nullable = true, precision = 2)
    public BigDecimal getUpper() {
        return upper;
    }

    public void setUpper(BigDecimal upper) {
        this.upper = upper;
    }

    @Basic
    @Column(name = "rate", nullable = true, precision = 0)
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "deduction", nullable = true, precision = 2)
    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rates rates = (Rates) o;
        return Objects.equals(id, rates.id) &&
                Objects.equals(taxBandId, rates.taxBandId) &&
                Objects.equals(min, rates.min) &&
                Objects.equals(upper, rates.upper) &&
                Objects.equals(rate, rates.rate) &&
                Objects.equals(deduction, rates.deduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxBandId, min, upper, rate, deduction);
    }
}
