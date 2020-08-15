package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "payee_tax_table", schema = "payroll", catalog = "")
public class PayeeTaxTable {
    private Integer id;
    private String description;
    private BigDecimal aidsLevy;
    private Integer currencyId;

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
    @Column(name = "description", nullable = true, length = 128)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "aids_levy", nullable = true, precision = 0)
    public BigDecimal getAidsLevy() {
        return aidsLevy;
    }

    public void setAidsLevy(BigDecimal aidsLevy) {
        this.aidsLevy = aidsLevy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayeeTaxTable that = (PayeeTaxTable) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(aidsLevy, that.aidsLevy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, aidsLevy);
    }

    @Basic
    @Column(name = "currency_id", nullable = false)
    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }
}
