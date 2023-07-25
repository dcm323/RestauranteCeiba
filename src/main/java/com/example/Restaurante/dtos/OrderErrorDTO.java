package com.example.Restaurante.dtos;

public class OrderErrorDTO extends OrderDTO{

    private String ErrorMsg;

    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }
}
