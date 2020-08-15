package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Company {
    private Integer id;
    private String name;
    private String address;
    private String suburb;
    private String city;
    private String country;
    private String email;
    private String phone;
    private Timestamp registrationDate;
    private String payrollCycle;
    private Integer operatingDay;
    private Boolean registrationComplete;
    private Boolean active;
    private Integer packageId;
    private Integer industryId;
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
    @Column(name = "name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 64)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "suburb", nullable = true, length = 64)
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 64)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 64)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 64)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "registration_date", nullable = true)
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "payroll_cycle", nullable = true, length = 32)
    public String getPayrollCycle() {
        return payrollCycle;
    }

    public void setPayrollCycle(String payrollCycle) {
        this.payrollCycle = payrollCycle;
    }

    @Basic
    @Column(name = "operating_day", nullable = true)
    public Integer getOperatingDay() {
        return operatingDay;
    }

    public void setOperatingDay(Integer operatingDay) {
        this.operatingDay = operatingDay;
    }

    @Basic
    @Column(name = "registration_complete", nullable = true)
    public Boolean getRegistrationComplete() {
        return registrationComplete;
    }

    public void setRegistrationComplete(Boolean registrationComplete) {
        this.registrationComplete = registrationComplete;
    }

    @Basic
    @Column(name = "active", nullable = true)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "package_id", nullable = true)
    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "industry_id", nullable = true)
    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    @Basic
    @Column(name = "currency_id", nullable = true)
    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(address, company.address) &&
                Objects.equals(suburb, company.suburb) &&
                Objects.equals(city, company.city) &&
                Objects.equals(country, company.country) &&
                Objects.equals(email, company.email) &&
                Objects.equals(phone, company.phone) &&
                Objects.equals(registrationDate, company.registrationDate) &&
                Objects.equals(payrollCycle, company.payrollCycle) &&
                Objects.equals(operatingDay, company.operatingDay) &&
                Objects.equals(registrationComplete, company.registrationComplete) &&
                Objects.equals(active, company.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, suburb, city, country, email, phone, registrationDate, payrollCycle, operatingDay, registrationComplete, active);
    }
}
