package org.zealot.algorithm.evaluation.jira.costexplorer;

import java.util.ArrayList;
import java.util.List;

public class CustomerSubscription {
    public String service;

    public Integer plan;

    public int startMonth;

    public CustomerSubscription(String s, Integer p, int m) {
        service = s;
        plan = p;
        startMonth = m;
    }
    public CustomerMonthlyBill monthlyBill;

    public Double annualBill;

    @Override
    public String toString() {
        List<String> s = new ArrayList<>();
        s.add(service);
        s.add(Integer.toString(plan));
        s.add(Integer.toString(startMonth));
        s.add(monthlyBill.toString());
        return s.toString();
    }
}
