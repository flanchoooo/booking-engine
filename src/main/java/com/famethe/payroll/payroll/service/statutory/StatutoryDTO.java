package com.famethe.payroll.payroll.service.statutory;

import java.io.Serializable;
import java.math.BigDecimal;

public class StatutoryDTO implements Serializable {
    String description;
    BigDecimal employeeContribution;
    BigDecimal companyContribution;

    public StatutoryDTO(String description) {
        this.description = description;
        this.employeeContribution = new BigDecimal(0);
        this.companyContribution = new BigDecimal(0);
    }

    public StatutoryDTO(String description, BigDecimal employeeContribution, BigDecimal companyContribution) {
        this.description = description;
        this.employeeContribution = employeeContribution;
        this.companyContribution = companyContribution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getEmployeeContribution() {
        return employeeContribution;
    }

    public void setEmployeeContribution(BigDecimal employeeContribution) {
        this.employeeContribution = employeeContribution;
    }

    public BigDecimal getCompanyContribution() {
        return companyContribution;
    }

    public void setCompanyContribution(BigDecimal companyContribution) {
        this.companyContribution = companyContribution;
    }
}
