package com.backbase.api.acl.data.transaction;

import com.backbase.api.common.data.BackendData;
import com.backbase.api.controller.v1.request.transaction.TransactionCreationInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BackendCreateTransactionPayload extends BackendData {
  private String accountNumber;
  private TransactionCreationInput transactionInput;
}
