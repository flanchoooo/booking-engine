package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tax_band", schema = "payroll", catalog = "")
public class TaxBand {
    private Integer id;
    private Integer taxTableId;
    private String name;

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
    @Column(name = "tax_table_id", nullable = false)
    public Integer getTaxTableId() {
        return taxTableId;
    }

    public void setTaxTableId(Integer taxTableId) {
        this.taxTableId = taxTableId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxBand taxBand = (TaxBand) o;
        return Objects.equals(id, taxBand.id) &&
                Objects.equals(taxTableId, taxBand.taxTableId) &&
                Objects.equals(name, taxBand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxTableId, name);
    }
}
