package com.lauracarpaciu.entities.bankAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupeNumber;
    private String groupeName;
    @ManyToMany
    private Collection<Employee> employees;

    public Group() {
        super();
    }

    public Group(String groupeName) {
        super();
        this.groupeName = groupeName;
    }

    public Long getGroupeNumber() {
        return groupeNumber;
    }

    public void setGroupeNumber(Long groupeNumber) {
        this.groupeNumber = groupeNumber;
    }

    public String getGroupeName() {
        return groupeName;
    }

    public void setGroupeName(String groupeName) {
        this.groupeName = groupeName;
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
