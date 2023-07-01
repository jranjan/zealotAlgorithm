package com.backbase.api.controller.v1;

import com.backbase.api.controller.v1.request.account.AccountCreationInput;
import com.backbase.api.controller.v1.request.account.AccountUpdateInput;
import com.backbase.api.controller.v1.response.account.AccountInfo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Account", description = "Manage account(s)")
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping(value="/{account}", method=RequestMethod.GET)
    public AccountInfo getAccount(
            @PathVariable("account") final String account) {
        AccountInfo response = new AccountInfo();
        return response;
    }

    @RequestMapping(method=RequestMethod.POST)
    public AccountInfo createAccount(@RequestBody AccountCreationInput accountCreationInput) {
        AccountInfo response = new AccountInfo();
        return response;
    }

    @RequestMapping(value="/{account_number}", method=RequestMethod.PUT)
    public AccountInfo updateAccount(
            @RequestBody AccountUpdateInput accountUpdateInput) {
        AccountInfo response = new AccountInfo();
        return response;
    }
    @RequestMapping(value="/{account_number}", method=RequestMethod.DELETE)
    public AccountInfo deleteAccount(
            @PathVariable("account_number") final String account_number) {
        AccountInfo response = new AccountInfo();
        return response;
    }
}
