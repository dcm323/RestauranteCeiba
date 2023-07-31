package com.example.Restaurante.dtos;

import com.example.Restaurante.util.OrderState;

import java.util.List;

public class OrderResponseDTO extends OrderDTO {

    private String local;
    private OrderState status;
    private Integer id;
    private List<OrderDetailDTO> details;

    public OrderResponseDTO(String local, OrderState status, Integer id, List<OrderDetailDTO> details) {
        this.local = local;
        this.status = status;
        this.id = id;
        this.details = details;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public OrderState getStatus() {
        return status;
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailDTO> details) {
        this.details = details;
    }
}

