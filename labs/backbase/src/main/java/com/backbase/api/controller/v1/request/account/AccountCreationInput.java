package com.backbase.api.controller.v1.request.account;

import com.backbase.api.common.BackbaseData;
import com.backbase.api.controller.v1.request.BackbaseApiInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountCreationInput extends BackbaseApiInput {
    private String accountHolderName;
    private String accountHolderPrimaryEmail;
    private String accountHolderMobile;
    private String bankName;
    private String branchCode;
}
