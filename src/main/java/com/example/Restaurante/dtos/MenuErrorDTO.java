package com.example.Restaurante.dtos;

public class MenuErrorDTO extends MenuDTO{

    private String ErrorMsg;

    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }
}
