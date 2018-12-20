package service;

import entity.Customer;
import implementation.CustomerDAOImpl;

import java.sql.SQLException;


public class CustomerService {
    private Customer customer;

    public void userRegistration(Customer customer) {
        System.out.println("Передача в сервисный слой осуществилась");
        System.out.println(customer.toString());
        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();

        try {
            customerDAOImpl.add(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int userLogIn(String login, String password) {
        System.out.println("Передача в сервисный слой осуществилась");

        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();

        int count = 0;
        try {
            this.customer = customerDAOImpl.getByLoginAndPassword(login, password);
            if (this.customer != null){
                System.out.println("Пользователь авторизирован");
                count = 1;
            } else {
                System.out.println("Введён неверный логин или пароль");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getCustomerID(){
        int id = this.customer.getIdCustomer();
        return id;
    }
}
