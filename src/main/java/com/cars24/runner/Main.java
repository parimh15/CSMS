//package com.cars24.runner;
//
//import java.util.Scanner;
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Boolean exit=true;
//        System.out.println("Enter choice:");
//        System.out.println("1. Add user");
//        System.out.println("2. Get user");
//        System.out.println("3. Exit");
//
//        while(exit){
//            int choice= scanner.nextInt();
//            switch(choice){
//                case 1: UI.addCustomer();
//                break;
//                case 2: UI.getCustomer();
//                break;
//                case 3: exit=false;
//
//            }
//        }
//    }
//}

package com.cars24.runner;

import com.cars24.config.DbConfig;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.services.Impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application starts");

//        try {
//            DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
//            System.out.println("Connection successful!");
//        } catch (SQLException e) {
//            System.out.println("Error connecting to the database");
//            throw new RuntimeException(e);
//        }
        //  DbUtil.getDbConnection(); //connected java to db

        //CustomerDaoImpl cust_dao = new CustomerDaoImpl();

//        cust_dao.createCustomer("John Doe", "9876543210", "john.doe@example.com", "Bangalore");
//        CustomerServiceImpl cust_service = new CustomerServiceImpl();

//        AddCustomerReq addCustomerReq = new AddCustomerReq();

//        addCustomerReq.setName("");
//        addCustomerReq.setPhone("");
//        addCustomerReq.setEmail("");
//        addCustomerReq.setAddress("");
//
//       String message = cust_dao.createCustomerV2("Kouu","8861773225","kousthubha.gk@cars24.com", "Bangalore");
//        String message = cust_service.registerCustomer(addCustomerReq);
//        System.out.println(message);


//        CustomerServiceImpl service = new CustomerServiceImpl();
//        CustomerProfileReq prof1 =new CustomerProfileReq();
//        prof1.setEmail("pari@gmail.com");
//        //prof1.setPhone("9972399318");
//        CustomerProfileRes res= service.get_CustomerProfile(prof1);System.out.println(res);

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        // Email or phone of the customer to delete
        DeleteReq profile =new DeleteReq();
        profile.setEmail("pari@gmail.com");

        String response = customerService.delete_customer(profile);

        // Print the response (success or error message)
        System.out.println(response);





    }


}
