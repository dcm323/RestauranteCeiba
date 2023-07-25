package com.example.Restaurante.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "idorder", nullable = false)
    private Integer idorder;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "reason", nullable = false)
    private String reason;

    public Claim(Integer id, Integer idorder, String local, String state, String reason) {
        this.id = id;
        this.idorder = idorder;
        this.local = local;
        this.state = state;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
