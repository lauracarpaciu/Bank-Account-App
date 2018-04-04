package com.lauracarpaciu.entities.bankAccount;

import com.lauracarpaciu.entities.data.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeCode;
    private String employeeName;
    @ManyToOne
    @JoinColumn(name="employeeSupId")
    private Employee employeeSup;
    @ManyToMany
    @JoinColumn(name="groupId")
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


    public Employee getEmployeeSup() {
        return employeeSup;
    }

    public void setEmployeeSup(Employee employeeSup) {
        this.employeeSup = employeeSup;
    }

    public Collection<Group> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Group> groupes) {
        this.groupes = groupes;
    }
}
