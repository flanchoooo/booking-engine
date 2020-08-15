package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Industry {
    private Integer id;
    private String name;
    private BigDecimal wcifRate;
    private String wcifCode;

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
    @Column(name = "name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "wcif_rate", nullable = true, precision = 0)
    public BigDecimal getWcifRate() {
        return wcifRate;
    }

    public void setWcifRate(BigDecimal wcifRate) {
        this.wcifRate = wcifRate;
    }

    @Basic
    @Column(name = "wcif_code", nullable = true, length = 8)
    public String getWcifCode() {
        return wcifCode;
    }

    public void setWcifCode(String wcifCode) {
        this.wcifCode = wcifCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Industry industry = (Industry) o;
        return Objects.equals(id, industry.id) &&
                Objects.equals(name, industry.name) &&
                Objects.equals(wcifRate, industry.wcifRate) &&
                Objects.equals(wcifCode, industry.wcifCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, wcifRate, wcifCode);
    }
}
