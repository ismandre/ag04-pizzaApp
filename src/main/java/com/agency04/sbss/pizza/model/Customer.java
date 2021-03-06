package com.agency04.sbss.pizza.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Customer {

    @Id
    @Column
    private String username;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "customerDetails_id")
    private CustomerDetails customerDetails;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Delivery> deliveries = new ArrayList<>();

    public Customer() {}

    public Customer(String username) {
        this.username = username;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(username, customer.username) && Objects.equals(customerDetails, customer.customerDetails) && Objects.equals(deliveries, customer.deliveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, customerDetails, deliveries);
    }
}
