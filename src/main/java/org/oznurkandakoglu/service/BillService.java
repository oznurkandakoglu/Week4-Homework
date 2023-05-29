package org.oznurkandakoglu.service;

import org.oznurkandakoglu.enums.CompanySectorType;
import org.oznurkandakoglu.models.Bill;

import java.util.List;
import java.util.Set;

public interface BillService {
    //Bill Service interface with methods
    List<Bill> getAllBill();
    List<Bill> getBillsGreaterThanValue(Double value);
    double getAverageOfBillGreaterThanValue(Double value);
    Set<CompanySectorType> getCompanySectorTypeLowerThanBillAverage(Double value);

}
