package com.lambdaschool.javaorderssqlite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ordnum;

    @Column
    @DecimalMin(".01")
    private double ordamount;

    @Column
    @DecimalMin(".01")
    private double advanceamount;

    @Column
    @NotNull
    private String orddescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnore
    private Customers customerorders;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agents agentorders;

    public Orders() {
        // Default Constructor
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }

    public Customers getCustomerorders() {
        return customerorders;
    }

    public void setCustomerorders(Customers customerorders) {
        this.customerorders = customerorders;
    }

    public Agents getAgentorders() {
        return agentorders;
    }

    public void setAgentorders(Agents agentorders) {
        this.agentorders = agentorders;
    }
}
