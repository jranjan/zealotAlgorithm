package com.backbase.api.controller.v1.response.account;

import com.backbase.api.common.data.entity.BranchInfo;
import com.backbase.api.controller.v1.response.BackbaseApiOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountInfo extends BackbaseApiOutput {
    private String accountNumber;
    private String accountType;
    private String accountHolderName;
    private String accountHolderPrimaryEmail;
    private String accountHolderMobile;
    private double dailyTransactionLimit;
    private BranchInfo branchDetails;
}
