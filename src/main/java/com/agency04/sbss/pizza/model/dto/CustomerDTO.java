package com.agency04.sbss.pizza.model.dto;

public class CustomerDTO {

    private String username;
    private int orders;

    public CustomerDTO(String username, int orders) {
        this.username = username;
        this.orders = orders;
    }

    public CustomerDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }
}
