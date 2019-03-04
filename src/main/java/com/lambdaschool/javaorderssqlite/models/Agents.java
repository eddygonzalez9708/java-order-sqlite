package com.lambdaschool.javaorderssqlite.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Agents")
public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentcode;

    @Column(nullable = false)
    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agentcustomers")
    private Set<Customers> customers;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agentorders")
    private Set<Orders> orders;

    public Agents() {
        // Default Constructor
    }

    public long getAgentcode() {
        return agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
