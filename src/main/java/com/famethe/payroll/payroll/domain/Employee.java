package com.famethe.payroll.payroll.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Employee {
    private Integer id;
    private Integer companyId;
    private String firstname;
    private String lastname;
    private String nationalId;
    private String nationality;
    private String gender;
    @JsonFormat(pattern="dd/MM/yyyy", timezone="CAT")
    private Timestamp dateOfBirth;
    private String address;
    private String suburb;
    private String city;
    private String country;
    private String phone;
    private String email;
    private String nokName;
    private String nokAddress;
    private String nokPhone;
    private String nokRelationship;
    private String maritalStatus;
    private String bankAccountNumber;
    private String bankAccountName;
    private String bankName;
    private String branch;
    @JsonFormat(pattern="dd/MM/yyyy", timezone="CAT")
    private Timestamp dateOfEngagement;
    @JsonFormat(pattern="dd/MM/yyyy", timezone="CAT")
    private Timestamp contractExpiryDate;
    private String contractType;
    private String department;
    private String position;
    private String employeeNumber;
    private BigDecimal rateOfPay;
    private Integer taxCreditsId;
    private Boolean active;
    private String status;
    private Double leaveEntitlement;
    private Double leaveBalance;

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
    @Column(name = "firstname", nullable = true, length = 64)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = true, length = 64)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "national_id", nullable = false, length = 64)
    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    @Basic
    @Column(name = "nationality", nullable = true, length = 64)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 8)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = true)
    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "suburb", nullable = true, length = 128)
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 128)
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
    @Column(name = "phone", nullable = true, length = 64)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nok_name", nullable = true, length = 64)
    public String getNokName() {
        return nokName;
    }

    public void setNokName(String nokName) {
        this.nokName = nokName;
    }

    @Basic
    @Column(name = "nok_address", nullable = true, length = 128)
    public String getNokAddress() {
        return nokAddress;
    }

    public void setNokAddress(String nokAddress) {
        this.nokAddress = nokAddress;
    }

    @Basic
    @Column(name = "nok_phone", nullable = true, length = 32)
    public String getNokPhone() {
        return nokPhone;
    }

    public void setNokPhone(String nokPhone) {
        this.nokPhone = nokPhone;
    }

    @Basic
    @Column(name = "nok_relationship", nullable = true, length = 32)
    public String getNokRelationship() {
        return nokRelationship;
    }

    public void setNokRelationship(String nokRelationship) {
        this.nokRelationship = nokRelationship;
    }

    @Basic
    @Column(name = "marital_status", nullable = true, length = 32)
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Basic
    @Column(name = "bank_account_number", nullable = true, length = 64)
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Basic
    @Column(name = "bank_account_name", nullable = true, length = 64)
    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    @Basic
    @Column(name = "bank_name", nullable = true, length = 64)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "branch", nullable = true, length = 64)
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Basic
    @Column(name = "date_of_engagement", nullable = true)
    public Timestamp getDateOfEngagement() {
        return dateOfEngagement;
    }

    public void setDateOfEngagement(Timestamp dateOfEngagement) {
        this.dateOfEngagement = dateOfEngagement;
    }

    @Basic
    @Column(name = "contract_expiry_date", nullable = true)
    public Timestamp getContractExpiryDate() {
        return contractExpiryDate;
    }

    public void setContractExpiryDate(Timestamp contractExpiryDate) {
        this.contractExpiryDate = contractExpiryDate;
    }

    @Basic
    @Column(name = "contract_type", nullable = true, length = 32)
    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    @Basic
    @Column(name = "department", nullable = true, length = 32)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "position", nullable = true, length = 32)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "employee_number", nullable = true, length = 4)
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
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
    @Column(name = "tax_credits_id", nullable = true)
    public Integer getTaxCreditsId() {
        return taxCreditsId;
    }

    public void setTaxCreditsId(Integer taxCreditsId) {
        this.taxCreditsId = taxCreditsId;
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
    @Column(name = "status", nullable = true, length = 32)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(status, employee.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Basic
    @Column(name = "leave_entitlement", nullable = true, precision = 0)
    public Double getLeaveEntitlement() {
        return leaveEntitlement;
    }

    public void setLeaveEntitlement(Double leaveEntitlement) {
        this.leaveEntitlement = leaveEntitlement;
    }

    @Basic
    @Column(name = "leave_balance", nullable = true, precision = 0)
    public Double getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(Double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
}
