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

//package com.cars24.runner;
//
//import com.cars24.config.DbConfig;
//import com.cars24.dao.impl.CustomerDaoImpl;
//import com.cars24.data.req.AddCustomerReq;
//import com.cars24.data.req.CustomerProfileReq;
//import com.cars24.data.res.CustomerProfileRes;
//import com.cars24.services.Impl.CustomerServiceImpl;
//import com.cars24.util.DbUtil;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Main {
//    public static void main (String[] args){
//        System.out.println("App start");
//        //DbUtil.getDbConnection();
//        /*CustomerDaoImpl cust= new CustomerDaoImpl();
//        CustomerProfileReq customerProfileReq= new CustomerProfileReq();
//        customerProfileReq.setEmail("ppp");
//        CustomerProfileRes response = cust.get_customer(customerProfileReq);
//        System.out.println(response);
//
//        CustomerServiceImpl serv= new CustomerServiceImpl();*/
//        //        dont directly call dao in main
////        CustomerDaoImpl cust_dao = new CustomerDaoImpl();
//        CustomerProfileReq req = new CustomerProfileReq();
//        req.setEmail("ppp");
//        //req.setPhone("8861773225");
//
//        CustomerServiceImpl serv = new CustomerServiceImpl();
//        CustomerProfileRes response = serv.get_CustomerProfile(req);
//
////        CustomerProfileRes response = cust_dao.getCustomer(req);
//        System.out.println(response);
//        //cust.create_customer("Nishi","7760709423","nishi@gmail.com","Bengaluru");
//        //String message= cust.create_customerv2("B","123","bbb","B");
//        //System.out.println(message);
//        /*CustomerServiceImpl customerService=new CustomerServiceImpl() ;
//        AddCustomerReq addCustomerReq=new AddCustomerReq();
//        addCustomerReq.setName("Parrr");
//        addCustomerReq.setPhone("8967452315");
//        addCustomerReq.setEmail("P@gmail.com");
//        addCustomerReq.setAddress("jaipur");
//
//        customerService.register_customer(addCustomerReq);*/
//
//
//
//        System.out.println("App stop");
//
//    }
//}

package com.cars24.runner;

import com.cars24.config.DbConfig;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.services.CustomerService;
import com.cars24.services.Impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application starts");

        try {
            DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            throw new RuntimeException(e);
        }
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
//        cannot do both at once - comment one out

//        CustomerDaoImpl cust_dao = new CustomerDaoImpl();
//        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
//        customerProfileReq.setEmail("kousthubha.gk@cars24.com");
//        customerProfileReq.setPhone("8861773225");
//
//        cust_dao.getCustomer(customerProfileReq);
//
//        CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
//
//        CustomerProfileReq req=new CustomerProfileReq();
//        req.setEmail("hhyy@g");
//        req.setPhone("0997655555");
//
//        CustomerProfileRes response=customerDaoImpl.getCustomer(req);
//        System.out.println(response);

        //CustomerService.getCustomerProfile(req);


        CustomerServiceImpl service = new CustomerServiceImpl();
        CustomerProfileReq prof1 =new CustomerProfileReq();
        prof1.setEmail("pari@gmail.com");
        //prof1.setPhone("9972399318");
        CustomerProfileRes res= service.get_CustomerProfile(prof1);


        // Create and populate a CustomerProfileReq object
        // Example phone to search for

        // Call the getCustomer method



        //Getting customer records
        //CustomerProfileReq req = new CustomerProfileReq();
        //req.setEmail("pari@gmail.com"); // Example email to search for
        //req.setPhone("0000543210");// Example phone to search for

        //CustomerDaoImpl cust=new CustomerDaoImpl();
        //cust.get_customer(req);
        //CustomerProfileRes response = cust.get_customer(req);
        System.out.println(res);

//        //Creating customer records
//        AddCustomerReq cust_req=new AddCustomerReq();
//        cust_req.setName("rickvi");
//        cust_req.setPhone("123432145");
//        cust_req.setAddress("bng");
//        cust_req.setEmail("r3@mail");
//        cust.CreateCustomer(cust_req);


    }


}
