package com.example.Restaurante.dtos;

public class ClaimErrorDTO extends ClaimDTO{
    private String ErrorMsg;

    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }
}

