package com.lauracarpaciu.entities.bankAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupNumber;
    private String groupName;
    @ManyToMany
    private Collection<Employee> employees;

    public Group() {
        super();
    }

    public Group(String groupeName) {
        super();
        this.groupName = groupeName;
    }

    public Long getGroupeNumber() {
        return groupNumber;
    }

    public void setGroupeNumber(Long groupeNumber) {
        this.groupNumber = groupeNumber;
    }

    public String getGroupeName() {
        return groupName;
    }

    public void setGroupeName(String groupeName) {
        this.groupName = groupeName;
    }
    @JsonIgnore
    @XmlTransient
    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
