package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Configs {
    private Integer id;
    private Integer companyId;
    private String name;
    private String description;
    private String value;

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
    @Column(name = "company_id", nullable = false)
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 16)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 64)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "value", nullable = true, length = 64)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configs configs = (Configs) o;
        return Objects.equals(id, configs.id) &&
                Objects.equals(companyId, configs.companyId) &&
                Objects.equals(name, configs.name) &&
                Objects.equals(description, configs.description) &&
                Objects.equals(value, configs.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, name, description, value);
    }
}
