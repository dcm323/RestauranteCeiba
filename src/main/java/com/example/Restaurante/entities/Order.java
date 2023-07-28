package com.example.Restaurante.entities;

import jakarta.persistence.*;

@Entity
@Table (name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role", nullable = false)
    private Character role;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "state", nullable = false)
    private String state;


    public Integer getOrder() {
        return id;
    }

    public void setOrder(Integer order) {
        this.id = order;
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

    public Order() {
    }

    public Order(Integer order, Character role, String local, String state) {
        this.id = order;
        this.role = role;
        this.local = local;
        this.state = state;
    }
}