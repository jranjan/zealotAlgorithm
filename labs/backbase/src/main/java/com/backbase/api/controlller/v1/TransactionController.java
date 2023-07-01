package com.backbase.api.controlller.v1;

import com.backbase.api.acl.TransactionStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("backbase/v1/accounts")
public class TransactionController {

    @RequestMapping(value="/{account_number}/transactions", method= RequestMethod.GET)
    public String getAccountTransaction(
            @PathVariable("account_number") final String account_number) {
        String res = String.format("Transaction details for account={%s}", account_number);
        return res;
    }

    @RequestMapping(value="/{account_number}/transactions", method=RequestMethod.POST)
    public String createTransaction(@PathVariable("account_number") final String account_number) {
        String res = String.format("Transaction for account {%s} created, Status={%s}", account_number, TransactionStatus.ACCEPTED);
        return res;
    }
}
