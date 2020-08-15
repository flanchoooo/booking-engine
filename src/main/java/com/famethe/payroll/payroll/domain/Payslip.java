package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payslip {
    private Integer id;
    private Integer employeeId;
    private BigDecimal rateOfPay;
    private Integer payrollId;
    private BigDecimal yearToDate;
    private Timestamp date;

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
    @Column(name = "employee_id", nullable = false)
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payslip payslip = (Payslip) o;
        return Objects.equals(id, payslip.id) &&
                Objects.equals(employeeId, payslip.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId);
    }

    @Basic
    @Column(name = "rate_of_pay", nullable = true, precision = 2)
    public BigDecimal getRateOfPay() {
        return rateOfPay;
    }

    public void setRateOfPay(BigDecimal rateOfPay) {
        this.rateOfPay = rateOfPay;
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
    @Column(name = "year_to_date", nullable = true, precision = 2)
    public BigDecimal getYearToDate() {
        return yearToDate;
    }

    public void setYearToDate(BigDecimal yearToDate) {
        this.yearToDate = yearToDate;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
