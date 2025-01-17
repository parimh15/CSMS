

package com.cars24.dao.impl;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;
import com.cars24.dao.CustomersDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDaoImpl implements CustomersDao {
    Connection connection = DbUtil.getDbConnection();
    private final static String INSERT_SUCCESS_MESSAGE = "customer added successfully";
    private final static String INSERT_ERROR_MESSAGE = "ERROR while adding customer";
    @Override
    public String create_customer(String name, String phone, String email, String address) {

        String insertSQL=
                "INSERT INTO customers (name,phone,email,address) VALUES"
                        +"("+"'"+name+"'"+","+
                        "'"+phone+"'"+"," +
                        "'"+email+"'"+","+
                        "'"+address+"'"+")"+";";

        //Connection connection= DbUtil.getDbConnection();
        try{
            Statement statement=connection.createStatement();
            int rowInserted= statement.executeUpdate(insertSQL);
            System.out.println(rowInserted+"row(s) inserted.");
        }
        catch(Exception e){
            System.out.println("Error while inserting date to customer table");
            e.printStackTrace();
        }

        //System.out.println(insertSQL);



        return "";
    }

    @Override
    public String create_customerv2(String name, String phone, String email, String address) {
        String insertSQL = "INSERT INTO customers (name,phone,email,address) VALUES (?,?,?,?)";
        Connection connection = DbUtil.getDbConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);

            int rowsInserted = preparedStatement.executeUpdate();
            return INSERT_SUCCESS_MESSAGE;
        } catch (Exception e) {

            e.printStackTrace();
            return INSERT_ERROR_MESSAGE;
        }

    }

    @Override
    public String CreateCustomer(AddCustomerReq addCustomerReq) {
        Connection connection = DbUtil.getDbConnection();
        String insertSQL="INSERT INTO customers (name,phone,email,address) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, addCustomerReq.getName());
            preparedStatement.setString(2, addCustomerReq.getAddress());
            preparedStatement.setString(3, addCustomerReq.getName());
            preparedStatement.setString(4, addCustomerReq.getAddress());

            int rowsInserted = preparedStatement.executeUpdate();
            return INSERT_SUCCESS_MESSAGE;
        } catch (Exception e) {

            //e.printStackTrace();
            return INSERT_ERROR_MESSAGE;
        }
    }

    @Override
    public CustomerProfileRes get_customer(CustomerProfileReq customerProfileReq) {

        String selectSQL= "SELECT name,email,phone,address from customers WHERE phone=? or email=?";
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, customerProfileReq.getPhone());
            preparedStatement.setString(2, customerProfileReq.getEmail());
            CustomerProfileRes response= new CustomerProfileRes();
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               response.setName(resultSet.getString("name"));
               response.setEmail(resultSet.getString("email"));
               response.setPhone(resultSet.getString("phone"));
               response.setAddress(resultSet.getString("address"));

            }
            return response;
        } catch (Exception e) {
            System.out.println("Data not found");
        }

        return null;
    }
}
