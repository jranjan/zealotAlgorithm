package com.backbase.api.acl.data.account;

import com.backbase.api.common.data.BackendData;
import com.backbase.api.controller.v1.request.account.AccountCreationInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BackendCreateAccountPayload extends BackendData {
    private AccountCreationInput accountCreationInput;
}
