package com.backbase.api.acl.data.account;


import com.backbase.api.common.data.BackendData;
import com.backbase.api.controller.v1.request.account.AccountUpdateInput;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackendUpdateAccountPayload extends BackendData {
  private String accountNumber;
  private AccountUpdateInput accountUpdateInput;
}
