package org.oznurkandakoglu.service.impl;

import org.oznurkandakoglu.models.Bill;
import org.oznurkandakoglu.models.Customer;
import org.oznurkandakoglu.service.CustomerService;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    public List<Customer> customerList = new ArrayList<>();
    public CustomerServiceImpl() {
        Customer customer = new Customer("Öznur Kandakoğlu", Month.JUNE,List.of(new Bill[]{(Bill) (new BillServiceImpl()).billList.get(0)}));
        Customer customer1 = new Customer("Ahmetcan Yıldırım", Month.APRIL,List.of(new Bill[]{(Bill) (new BillServiceImpl()).billList.get(1)}));
        Customer customer2 = new Customer("Can Deliorman", Month.MAY,List.of(new Bill[]{(Bill) (new BillServiceImpl()).billList.get(2)}));
        Customer customer3 = new Customer("Cansu Sanhal", Month.JUNE,List.of(new Bill[]{(Bill) (new BillServiceImpl()).billList.get(3)}));
        Customer customer4 = new Customer("Ayşe Aslan", Month.MAY,List.of(new Bill[]{(Bill) (new BillServiceImpl()).billList.get(4)}));
        addCustomer(customer);
        addCustomer(customer1);
        addCustomer(customer2);
        addCustomer(customer3);
        addCustomer(customer4);
    }

    @Override
    public List<Customer> getAllCustomer() {

        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public List<Customer> getFilteredCustomersByLetter(String letter) {
        return customerList.stream()
                .filter(customer -> customer.getName().contains("C") || customer.getName().contains("c"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getFilteredCustomersByMonth(Month month) {
        return customerList.stream()
                .filter(customer -> customer.getRegistrationDate().equals(month))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCustomersWithOrdersBelowThanValue(Double value) {

        return (List)this.customerList.stream().filter((customer) -> {
            return customer.getBillList().stream().anyMatch((Bill) -> {
                return Bill.getPrice() < value;
            });
        }).map((customer) -> {
            return customer.getName();
        }).collect(Collectors.toList());
    }

}
