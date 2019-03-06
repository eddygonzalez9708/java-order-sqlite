package com.lambdaschool.javaorderssqlite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "Customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custcode;

    @Column
    @NotNull
    private String custname;

    @Column
    @NotNull
    private String custcity;

    @Column
    @NotNull
    private String workingarea;

    @Column
    @NotNull
    private String custcountry;

    @Column
    @NotNull
    private String grade;

    @Column
    private double openingamt;

    @Column
    private double receiveamt;

    @Column
    private double paymentamt;

    @Column
    private double outstandingamt;

    @Column
    @NotNull
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agents agentcustomers;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customerorders")
    private Set<Orders> orders;

    public Customers() {
        // Default Constructor
    }

    public long getCustcode() {
        return custcode;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(double openingamt) {
        this.openingamt = openingamt;
    }

    public double getReceiveamt() {
        return receiveamt;
    }

    public void setReceiveamt(double receiveamt) {
        this.receiveamt = receiveamt;
    }

    public double getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt) {
        this.paymentamt = paymentamt;
    }

    public double getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agents getAgentcustomers() {
        return agentcustomers;
    }

    public void setAgentcustomers(Agents agentcustomers) {
        this.agentcustomers = agentcustomers;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
