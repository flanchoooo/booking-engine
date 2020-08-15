package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Pension {
    private Integer id;
    private String name;
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal rate;
    private BigDecimal fixed;

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
    @Column(name = "name", nullable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "min", nullable = true, precision = 0)
    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    @Basic
    @Column(name = "max", nullable = true, precision = 0)
    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
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
    @Column(name = "fixed", nullable = true, precision = 2)
    public BigDecimal getFixed() {
        return fixed;
    }

    public void setFixed(BigDecimal fixed) {
        this.fixed = fixed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pension pension = (Pension) o;
        return Objects.equals(id, pension.id) &&
                Objects.equals(name, pension.name) &&
                Objects.equals(min, pension.min) &&
                Objects.equals(max, pension.max) &&
                Objects.equals(rate, pension.rate) &&
                Objects.equals(fixed, pension.fixed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, min, max, rate, fixed);
    }
}
