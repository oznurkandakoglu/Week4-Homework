package org.oznurkandakoglu.models;

import lombok.Getter;
import lombok.Setter;
import org.oznurkandakoglu.enums.CompanySectorType;

@Getter
@Setter
public class Company {
    // Company model
    private String name;
    private CompanySectorType companySectorType;

    public Company(String name, CompanySectorType companySectorType) {
        this.name = name;
        this.companySectorType = companySectorType;
    }

}
