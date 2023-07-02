package com.backbase.api.acl.data.transaction;

import com.backbase.api.common.data.BackendData;
import com.backbase.api.controller.v1.response.transaction.TransactionInfoCollection;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class BackendTransactionPayload extends BackendData {
    private TransactionInfoCollection transactionInfoCollection;
}
