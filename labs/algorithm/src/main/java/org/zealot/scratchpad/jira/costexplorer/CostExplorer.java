package org.zealot.scratchpad.jira.costexplorer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
[
      JIRA  {BASIC, 9.99},0
        {STANDARD, 49.99},1
        {PREMIUM, 249.99}2
        ]*/
public class CostExplorer {
    public Map<String, ServicePlan> atlassianServicePlan = new HashMap<>();

    public Map<String, List<CustomerSubscription>> customerSubscription = new HashMap<>();

    public CostExplorer() {
        this.load();
    }
    public class ServicePlan {
        public Map<Integer, Double> plan = new HashMap<>();
    }



    public void computeMonthlyBill(String customer, List<CustomerSubscription> subscriptions) {
        if (customerSubscription.containsKey(customer)) {
            // Customer has subscription
            for (int i = 0; i < subscriptions.size(); i++) {
                CustomerSubscription cs = subscriptions.get(i);
                cs.monthlyBill = computeSubscriptionMonthlyBill(cs.service, cs.plan, cs.startMonth);
                cs.annualBill = computeAnnualBill(cs.monthlyBill);
            }
        }
    }

    public CustomerMonthlyBill computeSubscriptionMonthlyBill(String service, Integer plan, int startMonth) {
        CustomerMonthlyBill cmb = new CustomerMonthlyBill();
        // Let us fetch the cost for the given plan
        if (this.atlassianServicePlan.containsKey(service)) {
            ServicePlan sp = atlassianServicePlan.get(service);
            double individualCost = 0.0;
            if (sp.plan.containsKey(plan)) {
                individualCost = sp.plan.get(plan);
                System.out.println("---"+individualCost);
                sp.plan.put(plan, individualCost);
            }

            for (int i = startMonth; i <= 12; i++) {
                cmb.cost.put(i, individualCost);
            }
        }

        return cmb;
    }

    public double computeAnnualBill(CustomerMonthlyBill monthlyBill) {
        double annualCost = 0.0;
        for (int k : monthlyBill.cost.keySet()) {
            annualCost = monthlyBill.cost.get(k);
        }
        return annualCost;
    }

    public void load() {
       // public Map<String, ServicePlan> atlassianServicePlan = new HashMap<>();
        String[] atlassianServices = new String[]{"JIRA", "TRELLO", "BBC"};

        Map<Integer, Double> atlassianPlan = new HashMap<>();
        atlassianPlan.put(100, 9.99);
        atlassianPlan.put(200, 49.99);
        atlassianPlan.put(300, 249.99);

        for (int i =0; i < atlassianServices.length; i++) {
            ServicePlan sp = new ServicePlan();
            atlassianServicePlan.put(atlassianServices[i], sp);
        }
    }

    public void display() {
        for (String k : atlassianServicePlan.keySet()) {
            System.out.println(String.format("%s: Plan=%s", k, atlassianServicePlan.get(k)));
        }
    }

    public void displayBillStatement(String customer) {
        System.out.println(String.format("Customer=%s: Statement=%s", customer,
                customerSubscription.get(customer)));
    }
}
