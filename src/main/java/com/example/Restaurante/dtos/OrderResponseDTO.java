package com.example.Restaurante.dtos;

public class OrderResponseDTO extends OrderDTO{

    private String local;
    private String state;

    public OrderResponseDTO(String local, String state) {
        this.local = local;
        this.state = state;
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
}
