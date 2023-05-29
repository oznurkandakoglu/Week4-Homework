package org.oznurkandakoglu.models;

import lombok.Getter;
import lombok.Setter;
import org.oznurkandakoglu.enums.CompanySectorType;
import java.time.Month;

@Getter
@Setter
public class Bill extends Company {

    /** Bill model with
     * Double price
     * Month billDate
    **/

    private Double price;
    private Month billDate;


    // Bill model constructors
    public Bill(String name, CompanySectorType companySectorType) {
        super(name, companySectorType);
    }

    public Bill(String name, CompanySectorType companySectorType, Double price, Month billDate) {
        super(name, companySectorType);
        this.price = price;
        this.billDate = billDate;
    }
}
