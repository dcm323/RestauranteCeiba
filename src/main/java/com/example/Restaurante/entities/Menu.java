package com.example.Restaurante.entities;

import jakarta.persistence.*;

@Entity
@Table(name="plate")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="role", nullable = false)
    private Character role;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="price", nullable = false)
    private Integer price;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="url", nullable = false)
    private String url;

    @Column(name="category")
    private String category;

    @Column(name="state", nullable = false)
    private Boolean state;

    @Column(name="local")
    private String local;

    @Column(name="eta")
    private Double eta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getRole() {
        return role;
    }

    public void setRole(Character role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getEta() {
        return eta;
    }

    public void setEta(Double eta) {
        this.eta = eta;
    }

    public Menu(Integer id, Character role, String name, Integer price, String description, String url, String category, Boolean state, String local, Double eta) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.price = price;
        this.description = description;
        this.url = url;
        this.category = category;
        this.state = state;
        this.local = local;
        this.eta = eta;
    }
}
