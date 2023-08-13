package org.zealot.scratchpad.jira;

import org.junit.jupiter.api.Test;
import org.zealot.scratchpad.jira.costexplorer.CostExplorer;
import org.zealot.scratchpad.jira.costexplorer.CustomerSubscription;

import java.util.ArrayList;
import java.util.List;

public class CostExploreTest {
    @Test
    void displayCatelog() {
        CostExplorer cs = new CostExplorer();
        cs.display();
    }

    @Test
    void computeCost() {
        CostExplorer cs = new CostExplorer();

        // Customer ninja subscription
        List<CustomerSubscription> ms = new ArrayList<>();
        ms.add(new CustomerSubscription("JIRA", 100, 1));
        cs.customerSubscription.put("NINJA", ms);

        cs.computeMonthlyBill("NINJA", ms);
        cs.displayBillStatement("NINJA");
    }
}
