package org.oznurkandakoglu.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.Month;
import java.util.List;

@Getter
@Setter
public class Customer {

    private String name;
    private Month registrationDate;
    private List<Bill> billList;

    public Customer(String name, Month registrationDate, List<Bill> billList) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.billList = billList;
    }
}
