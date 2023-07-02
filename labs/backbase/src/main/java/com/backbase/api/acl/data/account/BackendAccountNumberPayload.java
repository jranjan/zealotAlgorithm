package com.backbase.api.acl.data.account;

import com.backbase.api.common.data.BackendData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BackendAccountNumberPayload extends BackendData {
  private String accountNumber;
}
