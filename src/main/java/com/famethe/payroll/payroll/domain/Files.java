package com.famethe.payroll.payroll.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Files {
    private Integer id;
    private Integer employeeId;
    private String name;
    private String path;
    private String url;

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

    @Basic
    @Column(name = "name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "path", nullable = true, length = 255)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Files files = (Files) o;
        return Objects.equals(id, files.id) &&
                Objects.equals(employeeId, files.employeeId) &&
                Objects.equals(name, files.name) &&
                Objects.equals(path, files.path) &&
                Objects.equals(url, files.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, name, path, url);
    }
}
