package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "payroll_deduction", schema = "payroll", catalog = "")
public class PayrollDeduction {
    private Integer id;
    private String description;
    private BigDecimal employeeContribution;
    private BigDecimal companyContribution;
    private Payroll payrollByPayrollId;
    private Integer payrollId;
    private Integer employeeId;
    private Employee employeeByEmployeeId;

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
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "employee_contribution", nullable = true, precision = 2)
    public BigDecimal getEmployeeContribution() {
        return employeeContribution;
    }

    public void setEmployeeContribution(BigDecimal employeeContribution) {
        this.employeeContribution = employeeContribution;
    }

    @Basic
    @Column(name = "company_contribution", nullable = true, precision = 2)
    public BigDecimal getCompanyContribution() {
        return companyContribution;
    }

    public void setCompanyContribution(BigDecimal companyContribution) {
        this.companyContribution = companyContribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayrollDeduction that = (PayrollDeduction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(employeeContribution, that.employeeContribution) &&
                Objects.equals(companyContribution, that.companyContribution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, employeeContribution, companyContribution);
    }

    @Basic
    @Column(name = "payroll_id", nullable = false)
    public Integer getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Integer payrollId) {
        this.payrollId = payrollId;
    }

    @Basic
    @Column(name = "employee_id", nullable = false)
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

}
