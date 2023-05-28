package org.oznurkandakoglu.service.impl;

import org.oznurkandakoglu.enums.CompanySectorType;
import org.oznurkandakoglu.models.Bill;
import org.oznurkandakoglu.service.BillService;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BillServiceImpl implements BillService {
    public List<Bill> billList = new ArrayList<>();

    public BillServiceImpl(){
        Bill bill = new Bill("Akbank", CompanySectorType.FINANCE,1800.0,Month.DECEMBER);
        Bill bill1 = new Bill("Popeyes", CompanySectorType.FOOD,1200.0,Month.JULY);
        Bill bill2 = new Bill("Apple", CompanySectorType.TECHNOLOGY,2800.0,Month.SEPTEMBER);
        Bill bill3 = new Bill("Memorial", CompanySectorType.HEALTH,800.0,Month.JUNE);
        Bill bill4 = new Bill("MSI", CompanySectorType.TECHNOLOGY,250.0,Month.JUNE);

        billList.add(bill);
        billList.add(bill1);
        billList.add(bill2);
        billList.add(bill3);
        billList.add(bill4);
    }

    @Override
    public List<Bill> getAllBill() {
        return this.billList;
    }


    @Override
    public List<Bill> getBillsGreaterThanValue(Double value) {
        return billList.stream()
                .filter(bill -> bill.getPrice() > value)
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageOfBillGreaterThanValue(Double value) {
        return billList.stream()
                .filter(order -> order.getPrice() > value)
                .mapToDouble(Bill::getPrice)
                .average()
                .orElse(0);
    }

    @Override
    public Set<CompanySectorType> getCompanySectorTypeLowerThanBillAverage(Double value) {
        boolean averageFilter = this.billList.stream().filter((Bill) -> {
            return Bill.getBillDate().getValue()== Month.JUNE.getValue();
        }).mapToDouble(Bill::getPrice).average().orElse(0.0) < value;
        Set<CompanySectorType> categories = new LinkedHashSet();
        if (averageFilter) {
            categories = (Set)this.billList.stream().filter((Bill) -> {
                return Bill.getBillDate().getValue() == Month.JUNE.getValue();
            }).map((Bill) -> {
                return Bill.getCompanySectorType();
            }).collect(Collectors.toSet());
        }

        return (Set)categories;
    }
}
