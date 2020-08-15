package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Platform {
    private Integer id;
    private String company;
    private String domain;
    private String ipAddress;
    private String version;
    private String logoUrl;
    private String port;
    private String createdBy;
    private Timestamp createdDate;
    private String lastModifiedBy;
    private Timestamp lastModifiedDate;

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
    @Column(name = "company", nullable = false, length = 64)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "domain", nullable = false, length = 64)
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Basic
    @Column(name = "ip_address", nullable = false, length = 16)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "version", nullable = false, length = 8)
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "logo_url", nullable = true, length = 128)
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Basic
    @Column(name = "port", nullable = true, length = 8)
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Basic
    @Column(name = "created_by", nullable = true, length = 255)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_date", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "last_modified_by", nullable = true, length = 255)
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Basic
    @Column(name = "last_modified_date", nullable = true)
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platform platform = (Platform) o;
        return Objects.equals(id, platform.id) &&
                Objects.equals(company, platform.company) &&
                Objects.equals(domain, platform.domain) &&
                Objects.equals(ipAddress, platform.ipAddress) &&
                Objects.equals(version, platform.version) &&
                Objects.equals(logoUrl, platform.logoUrl) &&
                Objects.equals(port, platform.port) &&
                Objects.equals(createdBy, platform.createdBy) &&
                Objects.equals(createdDate, platform.createdDate) &&
                Objects.equals(lastModifiedBy, platform.lastModifiedBy) &&
                Objects.equals(lastModifiedDate, platform.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, domain, ipAddress, version, logoUrl, port, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
    }
}
