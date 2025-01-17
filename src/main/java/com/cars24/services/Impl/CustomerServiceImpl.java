package com.cars24.services.Impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.util.DbUtil;
import com.cars24.validation.CustomerValidation;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDao= new CustomerDaoImpl();
    private CustomerValidation custValidator= new CustomerValidation();

    @Override
    public String register_customer(AddCustomerReq addCustomerReq) {
        try{
        custValidator.validate_AddCustomerReq(addCustomerReq); //first validate then create
        customerDao.CreateCustomer(addCustomerReq);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public CustomerProfileRes get_CustomerProfile(CustomerProfileReq customerProfileReq){
        CustomerDaoImpl cust = new CustomerDaoImpl();
        CustomerProfileRes response = cust.get_customer(customerProfileReq);
        return response;

    }
    @Override
    public String delete_customer(DeleteReq deleteReq) {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        return customerDao.delete_customer(deleteReq);
            }
        }













