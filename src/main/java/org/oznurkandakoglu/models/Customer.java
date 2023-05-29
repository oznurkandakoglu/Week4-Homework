package org.oznurkandakoglu.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.Month;
import java.util.List;

@Getter
@Setter
public class Customer {
    /** Customer model with
     * String name
     * Month registrationDate;
     * List<Bill> billList;
     */
    private String name;
    private Month registrationDate;
    private List<Bill> billList;

    // Customer model constructor
    public Customer(String name, Month registrationDate, List<Bill> billList) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.billList = billList;
    }
}
