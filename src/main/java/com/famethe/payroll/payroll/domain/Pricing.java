package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Pricing {
    private Integer id;
    private String period;
    private BigDecimal forexCost;
    private BigDecimal localCost;
    private Integer packageId;

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
    @Column(name = "period", nullable = true, length = 45)
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Basic
    @Column(name = "forex_cost", nullable = true, precision = 2)
    public BigDecimal getForexCost() {
        return forexCost;
    }

    public void setForexCost(BigDecimal forexCost) {
        this.forexCost = forexCost;
    }

    @Basic
    @Column(name = "local_cost", nullable = true, precision = 2)
    public BigDecimal getLocalCost() {
        return localCost;
    }

    public void setLocalCost(BigDecimal localCost) {
        this.localCost = localCost;
    }

    @Basic
    @Column(name = "package_id", nullable = false)
    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pricing pricing = (Pricing) o;
        return Objects.equals(id, pricing.id) &&
                Objects.equals(period, pricing.period) &&
                Objects.equals(forexCost, pricing.forexCost) &&
                Objects.equals(localCost, pricing.localCost) &&
                Objects.equals(packageId, pricing.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, period, forexCost, localCost, packageId);
    }
}
