package dao;

import model.Customer;

import java.util.*;

public class CustomerDao {
    private static final Map<Integer, Customer>  listCUSTOMER = new HashMap<>();
    static {
        intCustomer();
    }

    private static void intCustomer() {
        Customer customer1 = new Customer(1,"Doan Phuoc Trung","0978123456","trungdang@gmail.com");
        Customer customer2 = new Customer(2,"Nguyen Thanh Hung","0978567123","thanhhung@gmail.com");
        Customer customer3 = new Customer(3,"Tran Van Cong","0912345678","vancong@gmail.com");
        Customer customer4 = new Customer(4,"Quang Teo","097812890","quangteo@gmail.com");
        listCUSTOMER.put(customer1.getId(),customer1);
        listCUSTOMER.put(customer2.getId(),customer2);
        listCUSTOMER.put(customer3.getId(),customer3);
        listCUSTOMER.put(customer4.getId(),customer4);
    }
    public static Customer getCustomer(int id){
        return listCUSTOMER.get(id);
    }
    public static void addCustomer(Customer customer){
        listCUSTOMER.put(customer.getId(),customer);
    }
    public static Customer updateAndCreateCustomer(Customer customer){
        listCUSTOMER.put(customer.getId(),customer);
        return customer;
    }
    public static void deleteCustomer(int customerId){
        listCUSTOMER.remove(customerId);
    }
    public static List<Customer> getAllCustomer(){
        Collection<Customer> c = listCUSTOMER.values();
        List<Customer> customerList = new ArrayList<>();
        customerList.addAll(c);
        return customerList;
    }
}
