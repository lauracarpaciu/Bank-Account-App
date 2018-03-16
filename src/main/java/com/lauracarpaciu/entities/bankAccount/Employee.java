package com.lauracarpaciu.entities.bankAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeCode;
    private String employeeName;
    @ManyToOne
    @JoinColumn
    private Employee employeeSup;
    @ManyToMany
    @JoinColumn
    private Collection<Group> groupes;

    public Employee() {
        super();
    }

    public Employee(String employeeName) {
        super();
        this.employeeName = employeeName;
    }

    public Long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(Long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @JsonIgnore
    public Employee getEmployeeSup() {
        return employeeSup;
    }

    @JsonSetter
    public void setEmployeeSup(Employee employeeSup) {
        this.employeeSup = employeeSup;
    }
    @JsonIgnore
    @XmlTransient
    public Collection<Group> getGroupes() {
        return groupes;
    }

    @JsonSetter
    public void setGroupes(Collection<Group> groupes) {
        this.groupes = groupes;
    }
}
