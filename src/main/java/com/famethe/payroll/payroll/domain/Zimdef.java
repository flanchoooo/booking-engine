package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Zimdef {
    private Integer id;
    private BigDecimal rate;

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
    @Column(name = "rate", nullable = true, precision = 2)
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zimdef zimdef = (Zimdef) o;
        return Objects.equals(id, zimdef.id) &&
                Objects.equals(rate, zimdef.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rate);
    }
}
