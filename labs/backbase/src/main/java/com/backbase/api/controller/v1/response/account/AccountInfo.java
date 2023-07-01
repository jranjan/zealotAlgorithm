package com.backbase.api.controller.v1.response.account;

import com.backbase.api.common.BranchInfo;
import com.backbase.api.controller.v1.response.BackbaseApiOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountInfo extends BackbaseApiOutput {
    private int accountNumber;
    private String accountType;
    private String accountHolderName;
    private String accountHolderPrimaryEmail;
    private String accountHolderMobile;
    private String dailyTransactionLimit;
    private BranchInfo branchDetails;
}
