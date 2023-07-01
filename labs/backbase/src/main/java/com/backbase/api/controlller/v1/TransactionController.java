package com.backbase.api.controlller.v1;

import com.backbase.api.acl.TransactionStatus;
import com.backbase.api.controlller.v1.response.account.Account;
import com.backbase.api.controlller.v1.response.transaction.Transaction;
import com.backbase.api.controlller.v1.response.transaction.TransactionCollection;
import com.backbase.api.data.response.acl.transactions.ViewTransactionResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class TransactionController {

    @RequestMapping(value="/{account_number}/transactions", method= RequestMethod.GET)
    public TransactionCollection getAccountTransaction(
            @PathVariable("account_number") final String account_number) {
        TransactionCollection response = new TransactionCollection();
        return response;
    }

    @RequestMapping(value="/{account_number}/transactions", method=RequestMethod.POST)
    public Transaction createTransaction(@PathVariable("account_number") final String account_number) {
        Transaction response = new Transaction();
        return response;
    }
}
