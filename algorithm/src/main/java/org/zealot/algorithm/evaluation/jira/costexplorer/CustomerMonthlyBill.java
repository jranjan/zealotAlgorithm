package org.zealot.algorithm.evaluation.jira.costexplorer;

import java.util.HashMap;
import java.util.Map;

public class CustomerMonthlyBill {
    public Map<Integer, Double> cost = new HashMap<>();
    public CustomerMonthlyBill() {

    }

    @Override
    public String toString() {
        return cost.toString();
    }
}
