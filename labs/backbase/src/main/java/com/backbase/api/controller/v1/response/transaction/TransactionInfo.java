package com.backbase.api.controller.v1.response.transaction;

import com.backbase.api.common.data.entity.PaymentInfo;
import com.backbase.api.controller.v1.response.BackbaseApiOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionInfo extends BackbaseApiOutput {
    private String transactionId;
    private String date;
    private PaymentInfo paymentInfo;
}
