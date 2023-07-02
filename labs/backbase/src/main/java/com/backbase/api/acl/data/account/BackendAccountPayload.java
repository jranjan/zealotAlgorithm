package com.backbase.api.acl.data.account;

import com.backbase.api.common.data.BackbaseData;
import com.backbase.api.common.data.BackendData;
import com.backbase.api.controller.v1.response.account.AccountInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BackendAccountPayload extends BackendData {
  private AccountInfo accountInfo;
}
