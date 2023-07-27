package com.example.Restaurante.validations;

import org.springframework.stereotype.Component;

@Component
public class MenuValidation {

    public boolean validatePrice(Integer price){
        if(price<0){
            return true;
        }else{
            return false;
        }

    }

    public boolean LocalValidate(String local){
        if (local.isEmpty() || local == null){
            return true;
        }else{
            return  false;
        }
    }

}
