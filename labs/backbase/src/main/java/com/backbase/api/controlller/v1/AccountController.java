package com.backbase.api.controlller.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("backbase/v1/accounts")
public class AccountController {

    @RequestMapping(value="/{account}", method=RequestMethod.GET)
    public String getAccount(
            @PathVariable("account") final String account) {
        String res = String.format("account details for {%s}", account);
        return res;
    }

    @RequestMapping(value="/{account_type}", method=RequestMethod.POST)
    public String createAccount(@PathVariable("account_type") final String account_type) {
        String res = String.format("Account {%s} created", account_type);
        return res;
    }

    @RequestMapping(value="/{account_number}", method=RequestMethod.PUT)
    public String updateAccount(
            @PathVariable("account_number") final String account_number) {
        String res = String.format("Account {%s} is updated", account_number);
        return res;
    }
    @RequestMapping(value="/{account_number}", method=RequestMethod.DELETE)
    public String deleteAccount(
            @PathVariable("account_number") final String account_number) {
        String res = String.format("Account {%s} is deleted", account_number);
        return res;
    }
}
