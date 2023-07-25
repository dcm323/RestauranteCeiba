package com.example.Restaurante.dtos;

public class ClaimResponseDTO {

    private Integer id;
    private Integer idorder;
    private String local;
    private String reason;

    public ClaimResponseDTO(Integer id, Integer idorder, String local, String reason) {
        this.id = id;
        this.idorder = idorder;
        this.local = local;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
