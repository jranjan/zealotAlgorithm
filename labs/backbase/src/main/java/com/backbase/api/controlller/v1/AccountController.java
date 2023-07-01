package com.backbase.api.controlller.v1;

import com.backbase.api.controlller.v1.response.account.Account;
import com.backbase.api.controlller.v1.response.version.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping(value="/{account}", method=RequestMethod.GET)
    public Account getAccount(
            @PathVariable("account") final String account) {
        Account response = new Account();
        return response;
    }

    @RequestMapping(value="/{account_type}", method=RequestMethod.POST)
    public Account createAccount(@PathVariable("account_type") final String account_type) {
        Account response = new Account();
        return response;
    }

    @RequestMapping(value="/{account_number}", method=RequestMethod.PUT)
    public Account updateAccount(
            @PathVariable("account_number") final String account_number) {
        Account response = new Account();
        return response;
    }
    @RequestMapping(value="/{account_number}", method=RequestMethod.DELETE)
    public Account deleteAccount(
            @PathVariable("account_number") final String account_number) {
        Account response = new Account();
        return response;
    }
}
