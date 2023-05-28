package org.oznurkandakoglu.service;

import org.oznurkandakoglu.models.Customer;

import java.time.Month;
import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer();
    void addCustomer(Customer customer);
    List<Customer> getFilteredCustomersByLetter(String letter);
    List<Customer> getFilteredCustomersByMonth(Month month);
    List<String> getCustomersWithOrdersBelowThanValue(Double value);

}
