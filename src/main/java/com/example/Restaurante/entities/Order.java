package com.example.Restaurante.entities;

import jakarta.persistence.*;

@Entity
@Table (name="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order", nullable = false)
    private Integer order;

    @Column(name = "role", nullable = false)
    private Character role;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "state", nullable = false)
    private String state;



    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Character getRole() {
        return role;
    }

    public void setRole(Character role) {
        this.role = role;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Order(Integer order, Character role, String local, String state) {
        this.order = order;
        this.role = role;
        this.local = local;
        this.state = state;
    }
}