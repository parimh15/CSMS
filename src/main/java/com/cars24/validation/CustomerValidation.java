package com.cars24.validation;

import com.cars24.data.req.AddCustomerReq;

public class CustomerValidation {
    public void validate_AddCustomerReq(AddCustomerReq addCustomerReq){
        validate_CustomerName(addCustomerReq.getName());
        //not null, length 3- max 100, custom exception create
    }
    private void validate_CustomerName(String name){
        if (name== null){
            throw new IllegalArgumentException("Name cannot be EMPTY");
        }
        if (name.length()<3  || name.length()> 100){
            throw new IllegalArgumentException("Name should be 3 chars minimum or 100 chars max");
        }
    }

}
