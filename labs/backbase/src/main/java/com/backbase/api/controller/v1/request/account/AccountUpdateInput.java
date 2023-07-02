package com.backbase.api.controller.v1.request.account;

import com.backbase.api.controller.v1.request.BackbaseApiInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountUpdateInput extends BackbaseApiInput {
    private double dailyTransactionLimit;
    private String accountHolderName;
    private String accountHolderPrimaryEmail;
    private String accountHolderMobile;
}
