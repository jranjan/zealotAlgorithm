package com.backbase.api.controller.v1;

import com.backbase.api.controller.v1.request.transaction.TransactionInput;
import com.backbase.api.controller.v1.response.transaction.TransactionInfo;
import com.backbase.api.controller.v1.response.transaction.TransactionInfoCollection;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Transaction", description = "Manage transaction(s) associated with given account")
@RestController
@RequestMapping("/accounts")
public class TransactionController {

    @RequestMapping(value="/{account_number}/transactions", method= RequestMethod.GET)
    public TransactionInfoCollection getAccountTransaction(
            @PathVariable("account_number") final String account_number) {
        TransactionInfoCollection response = new TransactionInfoCollection();
        return response;
    }

    @RequestMapping(value="/{account_number}/transactions", method=RequestMethod.POST)
    public TransactionInfo createTransaction(@RequestBody TransactionInput transactionInput) {
        TransactionInfo response = new TransactionInfo();
        return response;
    }
}
