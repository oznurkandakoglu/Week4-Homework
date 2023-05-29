package org.oznurkandakoglu;

import lombok.RequiredArgsConstructor;
import org.oznurkandakoglu.service.impl.BillServiceImpl;
import org.oznurkandakoglu.service.impl.CustomerServiceImpl;
import java.time.Month;

@RequiredArgsConstructor
public class Main {

    // Created bill service and customer service
    private static final BillServiceImpl billService = new BillServiceImpl();
    private static final CustomerServiceImpl customerService = new CustomerServiceImpl();
    public static void main(String[] args) {

        // Print all methods

        //List all customers print
        System.out.println("-----------------------------------");
        System.out.println("List all customers\n");
        customerService.customerList
                .forEach(customer -> System.out.println("Customer: " + customer.getName()));
        System.out.println("-----------------------------------");

        //List customers whose names contain the letter 'C' print
        System.out.println("List customers whose names contain the letter 'C'\n");
        customerService.getFilteredCustomersByLetter("c")
                        .forEach(customer -> System.out.println(customer.getName()));
        System.out.println("-----------------------------------");

        //List the total amount of invoices for customers registered in June print
        System.out.println("List the total amount of invoices for customers registered in June\n");
        customerService.getFilteredCustomersByMonth(Month.JUNE)
                .forEach(customer -> System.out.println(customer.getName()));
        System.out.println("-----------------------------------");

        //List all invoices in the system print
        System.out.println("List all invoices in the system\n");
        billService.billList
                .forEach(bill -> System.out.println("Price: " + bill.getPrice()));
        System.out.println("-----------------------------------");

        //List invoices over 1500TL in the system print
        System.out.println("List invoices over 1500TL in the system\n");
        billService.getBillsGreaterThanValue(1500.0)
                .forEach(bill -> System.out.println("Price: " + bill.getPrice()));
        System.out.println("-----------------------------------");

        //Calculate the average of invoices over 1500TL in the system print
        System.out.println("Calculate the average of invoices over 1500TL in the system\n");
        System.out.println(billService.getAverageOfBillGreaterThanValue(1500.0));
        System.out.println("-----------------------------------");

        //List the names of customers with invoices under 500TL in the system print
        System.out.println("List the names of customers with invoices under 500TL in the system\n");
        customerService.getCustomersWithOrdersBelowThanValue(500.0)
                .forEach(System.out::println);
        System.out.println("-----------------------------------");

        //List the sectors in which companies with June invoices below 750 on average print
        System.out.println("List the sectors in which companies with June invoices below 750 on average\n");
        System.out.println(billService.getCompanySectorTypeLowerThanBillAverage(7500.0));
        System.out.println("-----------------------------------");

    }
}

